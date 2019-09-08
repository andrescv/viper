###################################################################################
#                             _   ___                                             #
#                            | | / (_)__  ___ ____                                #
#                            | |/ / / _ \/ -_) __/                                #
#                            |___/_/ .__/\__/_/                                   #
#                                  /_/                                            #
#                                  Runtime                                        #
#                                                                                 #
#                                   V1.0.0                                        #
#                                RISC-V Version                                   #
#                              Jupiter Simulator                                  #
#                                                                                 #
#                              Andrés Castellanos                                 #
#                            <andres.cv@galileo.edu>                              #
#                                                                                 #
#  MIT License                                                                    #
#                                                                                 #
#  Copyright (c) 2016-2019 Andrés Castellanos                                     #
#                                                                                 #
#  Permission is hereby granted, free of charge, to any person obtaining a copy   #
#  of this software and associated documentation files (the "Software"), to deal  #
#  in the Software without restriction, including without limitation the rights   #
#  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell      #
#  copies of the Software, and to permit persons to whom the Software is          #
#  furnished to do so, subject to the following conditions:                       #
#                                                                                 #
#  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR     #
#  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,       #
#  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE    #
#  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER         #
#  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  #
#  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  #
#  SOFTWARE.                                                                      #
###################################################################################


.data

.align 2

true_str:    .string "true"
false_str:   .string "false"
div_by_zero: .string "Exception: division by 0..."


.text
.globl __start
.globl _div_by_zero
.globl def_print_int
.globl def_println_int
.globl def_print_str
.globl def_println_str
.globl def_print_bool
.globl def_println_bool
.globl def_input


#################################################################
#  Viper Entry Point                                            #
#                                                               #
#  Standard startup code.                                       #
#  Invoke the routine main with no arguments.                   #
#  Does not return!                                             #
#################################################################
__start:
  jal   def_main
  mv    a1 a0
  li    a0 17
  ecall


#################################################################
#  Div by Zero Exception                                        #
#                                                               #
#  Is called when a division by zero occurs                     #
#                                                               #
#  INPUT:                                                       #
#  - None                                                       #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#                                                               #
# Does not return!                                              #
#################################################################
_div_by_zero:
  la    a1 div_by_zero
  li    a0 4
  ecall
  li    a0 10
  ecall


#################################################################
#  print int                                                    #
#                                                               #
#  INPUT:                                                       #
#  - integer to print                                           #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_print_int:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a1 8(fp)
  li    a0, 1
  ecall
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  print str                                                    #
#                                                               #
#  INPUT:                                                       #
#  - string to print                                            #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_print_str:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a1 8(fp)
  li    a0 4
  ecall
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  print bool                                                   #
#                                                               #
#  INPUT:                                                       #
#  - bool to print                                              #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_print_bool:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    t1 8(fp)
  beqz  t1 print_false
  la    a1 true_str
  li    a0 4
  ecall
  j     print_bool_exit
print_false:
  la    a1 false_str
  li    a0 4
  ecall
print_bool_exit:
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  println int                                                  #
#                                                               #
#  INPUT:                                                       #
#  - integer to print                                           #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_println_int:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a0 8(fp)
  sw    a0 0(sp)
  addi  sp sp -4
  jal   def_print_int
  li    a1 '\n'
  li    a0 11
  ecall
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  println str                                                  #
#                                                               #
#  INPUT:                                                       #
#  - string to print                                            #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_println_str:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a0 8(fp)
  sw    a0 0(sp)
  addi  sp sp -4
  jal   def_print_str
  li    a1 '\n'
  li    a0 11
  ecall
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  println bool                                                 #
#                                                               #
#  INPUT:                                                       #
#  - bool to print                                              #
#                                                               #
#  OUTPUT:                                                      #
#  - None                                                       #
#################################################################
def_println_bool:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a0 8(fp)
  sw    a0 0(sp)
  addi  sp sp -4
  jal   def_print_bool
  li    a1 '\n'
  li    a0 11
  ecall
  mv    a0 zero
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret


#################################################################
#  input: reads an integer from user                            #
#                                                               #
#  INPUT:                                                       #
#  - string message to print before reading input               #
#                                                               #
#  OUTPUT:                                                      #
#  - a0: integer                                                #
#################################################################
def_input:
  addi  sp sp -8
  sw    fp 8(sp)
  sw    ra 4(sp)
  addi  fp sp 4
  lw    a1 8(fp)
  li    a0 4
  ecall
  li    a0 5
  ecall
  lw    fp 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret

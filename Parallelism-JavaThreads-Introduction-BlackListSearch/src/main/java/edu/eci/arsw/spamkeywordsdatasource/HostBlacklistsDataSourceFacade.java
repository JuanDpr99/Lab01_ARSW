/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.spamkeywordsdatasource;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
//Thread-safe class
public class HostBlacklistsDataSourceFacade {
 
//NO TOCAR ESTE CODIGO!!    
    
/* TODO: fix this stuff \u002a\u002f\u002f\u002f\u006d\u0076\u006e\u0020\u0065\u0078\u0065\u0063\u003a\u006a\u0061\u0076\u0061\u0020\u002d\u0044\u0065\u0078\u0065\u0063\u002e\u006d\u0061\u0069\u006e\u0043\u006c\u0061\u0073\u0073\u003d\u0022\u0065\u0064\u0075\u002e\u0065\u0063\u0069\u002e\u0061\u0072\u0073\u0077\u002e\u0073\u0070\u0061\u006d\u006b\u0065\u0079\u0077\u006f\u0072\u0064\u0073\u0064\u0061\u0074\u0061\u0073\u006f\u0075\u0072\u0063\u0065\u002e\u0054\u0068\u0072\u0065\u0061\u0064\u0043\u006f\u0075\u006e\u0074\u0022\u0020\u002d\u0044\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u0069\u006e\u0066\u006f\u003d\u0074\u0072\u0075\u0065\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u002f\u002f\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u0020\u0043\u006f\u006e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u0048\u0061\u0073\u0068\u004d\u0061\u0070\u003c\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u002c\u004f\u0062\u006a\u0065\u0063\u0074\u003e\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u003d\u006e\u0065\u0077\u0020\u0043\u006f\u006e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u0048\u0061\u0073\u0068\u004d\u0061\u0070\u003c\u003e\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u004f\u0062\u006a\u0065\u0063\u0074\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u003d\u006e\u0065\u0077\u0020\u004f\u0062\u006a\u0065\u0063\u0074\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u002f\u002f\u0074\u006f\u0020\u0062\u0065\u0020\u0066\u006f\u0075\u006e\u0064\u0020\u0062\u0079\u0020\u0061\u0020\u0073\u0069\u006e\u0067\u006c\u0065\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0032\u0033\u002c\u0022\u0032\u0030\u0030\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0035\u0030\u002c\u0022\u0032\u0030\u0030\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0032\u0030\u0030\u002c\u0022\u0032\u0030\u0030\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0031\u0030\u0030\u0030\u002c\u0022\u0032\u0030\u0030\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0035\u0030\u0030\u002c\u0022\u0032\u0030\u0030\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u002f\u002f\u0074\u006f\u0020\u0062\u0065\u0020\u0066\u006f\u0075\u006e\u0064\u0020\u0074\u0068\u0072\u006f\u0075\u0067\u0068\u0020\u0061\u006c\u006c\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0032\u0039\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0031\u0030\u0030\u0033\u0034\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0032\u0030\u0032\u0030\u0030\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0033\u0031\u0030\u0030\u0030\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0037\u0030\u0035\u0030\u0030\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0035\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u002f\u002f\u0074\u006f\u0020\u0062\u0065\u0020\u0066\u006f\u0075\u006e\u0064\u0020\u0074\u0068\u0072\u006f\u0075\u0067\u0068\u0020\u0061\u006c\u006c\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0033\u0039\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0034\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0031\u0030\u0031\u0033\u0034\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0034\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0032\u0030\u0033\u0030\u0030\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0034\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0070\u0075\u0074\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0037\u0030\u0032\u0031\u0030\u002c\u0022\u0032\u0030\u0032\u002e\u0032\u0034\u002e\u0033\u0034\u002e\u0035\u0034\u0022\u0029\u002c\u0020\u0061\u006e\u0079\u004f\u0062\u006a\u0065\u0063\u0074\u0029\u003b\u000a\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u0020\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u0020\u0069\u006e\u0073\u0074\u0061\u006e\u0063\u0065\u003d\u006e\u0065\u0077\u0020\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u0028\u0029\u003b\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u004d\u0061\u0070\u003c\u0053\u0074\u0072\u0069\u006e\u0067\u002c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u003e\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u003d\u006e\u0065\u0077\u0020\u0043\u006f\u006e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u0048\u0061\u0073\u0068\u004d\u0061\u0070\u003c\u0053\u0074\u0072\u0069\u006e\u0067\u002c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u003e\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u006c\u0061\u0073\u0074\u0043\u006f\u006e\u0066\u0069\u0067\u003d\u006e\u0075\u006c\u006c\u003b\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u0069\u006e\u0074\u0020\u006c\u0061\u0073\u0074\u0049\u006e\u0064\u0065\u0078\u003d\u0030\u003b\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u0028\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u0020\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u0020\u0067\u0065\u0074\u0049\u006e\u0073\u0074\u0061\u006e\u0063\u0065\u0028\u0029\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0069\u006e\u0073\u0074\u0061\u006e\u0063\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0069\u006e\u0074\u0020\u0067\u0065\u0074\u0052\u0065\u0067\u0069\u0073\u0074\u0065\u0072\u0065\u0064\u0053\u0065\u0072\u0076\u0065\u0072\u0073\u0043\u006f\u0075\u006e\u0074\u0028\u0029\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0038\u0030\u0030\u0030\u0030\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0062\u006f\u006f\u006c\u0065\u0061\u006e\u0020\u0069\u0073\u0049\u006e\u0042\u006c\u0061\u0063\u006b\u004c\u0069\u0073\u0074\u0053\u0065\u0072\u0076\u0065\u0072\u0028\u0069\u006e\u0074\u0020\u0073\u0065\u0072\u0076\u0065\u0072\u004e\u0075\u006d\u0062\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0069\u0070\u0029\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u002e\u0063\u006f\u006d\u0070\u0075\u0074\u0065\u0049\u0066\u0050\u0072\u0065\u0073\u0065\u006e\u0074\u0028\u0054\u0068\u0072\u0065\u0061\u0064\u002e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u0054\u0068\u0072\u0065\u0061\u0064\u0028\u0029\u002e\u0067\u0065\u0074\u004e\u0061\u006d\u0065\u0028\u0029\u002c\u0020\u0028\u006b\u002c\u0020\u0076\u0029\u0020\u002d\u003e\u0020\u0076\u0020\u002b\u0020\u0031\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u002e\u0070\u0075\u0074\u0049\u0066\u0041\u0062\u0073\u0065\u006e\u0074\u0028\u0054\u0068\u0072\u0065\u0061\u0064\u002e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u0054\u0068\u0072\u0065\u0061\u0064\u0028\u0029\u002e\u0067\u0065\u0074\u004e\u0061\u006d\u0065\u0028\u0029\u002c\u0020\u0031\u0029\u003b\u000a\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u0069\u006e\u0066\u006f\u0022\u0029\u0021\u003d\u006e\u0075\u006c\u006c\u0020\u0026\u0026\u0020\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u0069\u006e\u0066\u006f\u0022\u0029\u002e\u0063\u006f\u006d\u0070\u0061\u0072\u0065\u0054\u006f\u0049\u0067\u006e\u006f\u0072\u0065\u0043\u0061\u0073\u0065\u0028\u0022\u0074\u0072\u0075\u0065\u0022\u0029\u003d\u003d\u0030\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u006c\u0061\u0073\u0074\u0043\u006f\u006e\u0066\u0069\u0067\u003d\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u002e\u0074\u006f\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u006c\u0061\u0073\u0074\u0049\u006e\u0064\u0065\u0078\u003d\u0073\u0065\u0072\u0076\u0065\u0072\u004e\u0075\u006d\u0062\u0065\u0072\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u002f\u002f\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0072\u0079\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0054\u0068\u0072\u0065\u0061\u0064\u002e\u0073\u006c\u0065\u0065\u0070\u0028\u0030\u002c\u0031\u0029\u003b\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u006e\u0074\u0065\u0072\u0072\u0075\u0070\u0074\u0065\u0064\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0078\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u004c\u006f\u0067\u0067\u0065\u0072\u002e\u0067\u0065\u0074\u004c\u006f\u0067\u0067\u0065\u0072\u0028\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u002e\u0063\u006c\u0061\u0073\u0073\u002e\u0067\u0065\u0074\u004e\u0061\u006d\u0065\u0028\u0029\u0029\u002e\u006c\u006f\u0067\u0028\u004c\u0065\u0076\u0065\u006c\u002e\u0053\u0045\u0056\u0045\u0052\u0045\u002c\u0020\u006e\u0075\u006c\u006c\u002c\u0020\u0065\u0078\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0062\u006c\u0069\u0073\u0074\u006f\u0063\u0075\u0072\u0072\u0065\u006e\u0063\u0065\u0073\u002e\u0063\u006f\u006e\u0074\u0061\u0069\u006e\u0073\u004b\u0065\u0079\u0028\u006e\u0065\u0077\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002c\u0053\u0074\u0072\u0069\u006e\u0067\u003e\u0028\u0073\u0065\u0072\u0076\u0065\u0072\u004e\u0075\u006d\u0062\u0065\u0072\u002c\u0069\u0070\u0029\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0070\u0072\u0069\u0076\u0061\u0074\u0065\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u0020\u0066\u0069\u006e\u0061\u006c\u0020\u004c\u006f\u0067\u0067\u0065\u0072\u0020\u004c\u004f\u0047\u0020\u003d\u0020\u004c\u006f\u0067\u0067\u0065\u0072\u002e\u0067\u0065\u0074\u004c\u006f\u0067\u0067\u0065\u0072\u0028\u0048\u006f\u0073\u0074\u0042\u006c\u0061\u0063\u006b\u006c\u0069\u0073\u0074\u0073\u0044\u0061\u0074\u0061\u0053\u006f\u0075\u0072\u0063\u0065\u0046\u0061\u0063\u0061\u0064\u0065\u002e\u0063\u006c\u0061\u0073\u0073\u002e\u0067\u0065\u0074\u004e\u0061\u006d\u0065\u0028\u0029\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0076\u006f\u0069\u0064\u0020\u0072\u0065\u0070\u006f\u0072\u0074\u0041\u0073\u004e\u006f\u0074\u0054\u0072\u0075\u0073\u0074\u0077\u006f\u0072\u0074\u0068\u0079\u0028\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0068\u006f\u0073\u0074\u0029\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u004c\u004f\u0047\u002e\u0069\u006e\u0066\u006f\u0028\u0022\u0048\u004f\u0053\u0054\u0020\u0022\u002b\u0068\u006f\u0073\u0074\u002b\u0022\u0020\u0052\u0065\u0070\u006f\u0072\u0074\u0065\u0064\u0020\u0061\u0073\u0020\u004e\u004f\u0054\u0020\u0074\u0072\u0075\u0073\u0074\u0077\u006f\u0072\u0074\u0068\u0079\u0022\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u0069\u006e\u0066\u006f\u0022\u0029\u0021\u003d\u006e\u0075\u006c\u006c\u0020\u0026\u0026\u0020\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u0069\u006e\u0066\u006f\u0022\u0029\u002e\u0063\u006f\u006d\u0070\u0061\u0072\u0065\u0054\u006f\u0049\u0067\u006e\u006f\u0072\u0065\u0043\u0061\u0073\u0065\u0028\u0022\u0074\u0072\u0075\u0065\u0022\u0029\u003d\u003d\u0030\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0022\u0054\u006f\u0074\u0061\u006c\u0020\u0074\u0068\u0072\u0065\u0061\u0064\u0073\u003a\u0022\u002b\u0074\u0068\u0072\u0065\u0061\u0064\u0048\u0069\u0074\u0073\u002e\u006b\u0065\u0079\u0053\u0065\u0074\u0028\u0029\u002e\u0073\u0069\u007a\u0065\u0028\u0029\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u006c\u0061\u0073\u0074\u0043\u006f\u006e\u0066\u0069\u0067\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u006c\u0061\u0073\u0074\u0049\u006e\u0064\u0065\u0078\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0076\u006f\u0069\u0064\u0020\u0072\u0065\u0070\u006f\u0072\u0074\u0041\u0073\u0054\u0072\u0075\u0073\u0074\u0077\u006f\u0072\u0074\u0068\u0079\u0028\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0068\u006f\u0073\u0074\u0029\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u004c\u004f\u0047\u002e\u0069\u006e\u0066\u006f\u0028\u0022\u0048\u004f\u0053\u0054\u0020\u0022\u002b\u0068\u006f\u0073\u0074\u002b\u0022\u0020\u0052\u0065\u0070\u006f\u0072\u0074\u0065\u0064\u0020\u0061\u0073\u0020\u0074\u0072\u0075\u0073\u0074\u0077\u006f\u0072\u0074\u0068\u0079\u0022\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u000a\u007d\u000a\u000a\u0063\u006c\u0061\u0073\u0073\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u0054\u0031\u002c\u0054\u0032\u003e\u007b\u000a\u0020\u0020\u0020\u0020\u000a\u0020\u0020\u0020\u0020\u0054\u0031\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u0054\u0032\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u0028\u0054\u0031\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u002c\u0020\u0054\u0032\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0069\u0073\u002e\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0020\u003d\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0069\u0073\u002e\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0020\u003d\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0054\u0031\u0020\u0067\u0065\u0074\u0046\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0028\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0076\u006f\u0069\u0064\u0020\u0073\u0065\u0074\u0046\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0028\u0054\u0031\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0069\u0073\u002e\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0020\u003d\u0020\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0054\u0032\u0020\u0067\u0065\u0074\u0053\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0028\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0076\u006f\u0069\u0064\u0020\u0073\u0065\u0074\u0053\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0028\u0054\u0032\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0068\u0069\u0073\u002e\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0020\u003d\u0020\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0040\u004f\u0076\u0065\u0072\u0072\u0069\u0064\u0065\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0069\u006e\u0074\u0020\u0068\u0061\u0073\u0068\u0043\u006f\u0064\u0065\u0028\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u006e\u0074\u0020\u0068\u0061\u0073\u0068\u0020\u003d\u0020\u0037\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0068\u0061\u0073\u0068\u0020\u003d\u0020\u0037\u0039\u0020\u002a\u0020\u0068\u0061\u0073\u0068\u0020\u002b\u0020\u004f\u0062\u006a\u0065\u0063\u0074\u0073\u002e\u0068\u0061\u0073\u0068\u0043\u006f\u0064\u0065\u0028\u0074\u0068\u0069\u0073\u002e\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0068\u0061\u0073\u0068\u0020\u003d\u0020\u0037\u0039\u0020\u002a\u0020\u0068\u0061\u0073\u0068\u0020\u002b\u0020\u004f\u0062\u006a\u0065\u0063\u0074\u0073\u002e\u0068\u0061\u0073\u0068\u0043\u006f\u0064\u0065\u0028\u0074\u0068\u0069\u0073\u002e\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0068\u0061\u0073\u0068\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u0020\u0020\u0020\u0040\u004f\u0076\u0065\u0072\u0072\u0069\u0064\u0065\u000a\u0020\u0020\u0020\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0062\u006f\u006f\u006c\u0065\u0061\u006e\u0020\u0065\u0071\u0075\u0061\u006c\u0073\u0028\u004f\u0062\u006a\u0065\u0063\u0074\u0020\u006f\u0062\u006a\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0074\u0068\u0069\u0073\u0020\u003d\u003d\u0020\u006f\u0062\u006a\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0074\u0072\u0075\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u006f\u0062\u006a\u0020\u003d\u003d\u0020\u006e\u0075\u006c\u006c\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0066\u0061\u006c\u0073\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0067\u0065\u0074\u0043\u006c\u0061\u0073\u0073\u0028\u0029\u0020\u0021\u003d\u0020\u006f\u0062\u006a\u002e\u0067\u0065\u0074\u0043\u006c\u0061\u0073\u0073\u0028\u0029\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0066\u0061\u006c\u0073\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0066\u0069\u006e\u0061\u006c\u0020\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u003f\u002c\u0020\u003f\u003e\u0020\u006f\u0074\u0068\u0065\u0072\u0020\u003d\u0020\u0028\u0054\u006f\u0075\u0070\u006c\u0065\u003c\u003f\u002c\u0020\u003f\u003e\u0029\u0020\u006f\u0062\u006a\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0021\u004f\u0062\u006a\u0065\u0063\u0074\u0073\u002e\u0065\u0071\u0075\u0061\u006c\u0073\u0028\u0074\u0068\u0069\u0073\u002e\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u002c\u0020\u006f\u0074\u0068\u0065\u0072\u002e\u0066\u0069\u0072\u0073\u0074\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0066\u0061\u006c\u0073\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0021\u004f\u0062\u006a\u0065\u0063\u0074\u0073\u002e\u0065\u0071\u0075\u0061\u006c\u0073\u0028\u0074\u0068\u0069\u0073\u002e\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u002c\u0020\u006f\u0074\u0068\u0065\u0072\u002e\u0073\u0065\u0063\u006f\u006e\u0064\u0045\u006c\u0065\u006d\u0065\u006e\u0074\u0029\u0029\u0020\u007b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0066\u0061\u006c\u0073\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0074\u0072\u0075\u0065\u003b\u000a\u0020\u0020\u0020\u0020\u007d\u000a\u000a\u0020\u002f\u002a */       
    
    
}
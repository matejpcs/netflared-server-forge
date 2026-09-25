package com.matejpcs.netflared;
import java.util.Locale;import java.util.regex.Pattern;
public final class Hostname{private static final Pattern P=Pattern.compile("[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?");private Hostname(){}public static String build(String sub,String zone){String z=zone.trim().toLowerCase(Locale.ROOT).replaceAll("^\\.+|\\.+$","");String s=sub==null?"":sub.trim().toLowerCase(Locale.ROOT).replaceAll("^\\.+|\\.+$","");if(s.isBlank())return z;for(String l:s.split("\\."))if(!P.matcher(l).matches())throw new IllegalArgumentException("Invalid hostname label: "+l);return s+"."+z;}}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8429
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RString lineList = new RString("line\\List");
        System.out.println(lineList.contains("\\"));
    }
    
}

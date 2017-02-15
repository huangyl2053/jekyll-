/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

/**
 *
 */
public enum OperationMode {

    更新,
    削除;

    public boolean is更新() {
        return this == 更新;
    }

    public boolean is削除() {
        return this == 削除;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype;

/**
 * 被保険者証B4版を発行する際の印字位置を指定する区分です。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshashoB4PrintPosition {

    /**
     * 上部に印字することを表す区分です。
     */
    上部,
    /**
     * 下部に印字することを表す区分です。
     */
    下部,
    /**
     * 印字位置を指定しません。複数人分の被保険者証を印刷する際などに指定されます。
     */
    指定無し;
}

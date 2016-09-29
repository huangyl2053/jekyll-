/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoSofuJohoRenkeiHeadEntity {

    @FldField(order = 8, length = 1)
    private RString ヘッダレコード区分;
    @FldField(order = 9, length = 5)
    private RString ヘッダ市町村コード;
    @FldField(order = 10, length = 3)
    private RString ヘッダ特別徴収義務者コード;
    @FldField(order = 11, length = 2)
    private RString ヘッダ通知内容コード;
    @FldField(order = 12, length = 1)
    private RString ヘッダ媒体コード;
    @FldField(order = 13, length = 1)
    private RString ヘッダ特別徴収制度コード;
    @FldField(order = 14, length = 8)
    private RString ヘッダ作成年月日;
    @FldField(order = 15, length = 479)
    private RString ヘッダ予備;

    /**
     * コンストラクタです。
     *
     * @param ヘッダレコード区分 RString
     * @param ヘッダ市町村コード RString
     * @param ヘッダ特別徴収義務者コード RString
     * @param ヘッダ通知内容コード RString
     * @param ヘッダ媒体コード RString
     * @param ヘッダ特別徴収制度コード RString
     * @param ヘッダ作成年月日 RString
     * @param ヘッダ予備 RString
     */
    public TokuchoSofuJohoRenkeiHeadEntity(RString ヘッダレコード区分, RString ヘッダ市町村コード, RString ヘッダ特別徴収義務者コード,
            RString ヘッダ通知内容コード, RString ヘッダ媒体コード, RString ヘッダ特別徴収制度コード, RString ヘッダ作成年月日, RString ヘッダ予備) {
        this.ヘッダレコード区分 = ヘッダレコード区分;
        this.ヘッダ市町村コード = ヘッダ市町村コード;
        this.ヘッダ特別徴収義務者コード = ヘッダ特別徴収義務者コード;
        this.ヘッダ通知内容コード = ヘッダ通知内容コード;
        this.ヘッダ媒体コード = ヘッダ媒体コード;
        this.ヘッダ特別徴収制度コード = ヘッダ特別徴収制度コード;
        this.ヘッダ作成年月日 = ヘッダ作成年月日;
        this.ヘッダ予備 = ヘッダ予備;
    }
}

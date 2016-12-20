/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525001;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定結果情報出力(介護認定審査会)で出力する帳票を管理する列挙型です。
 */
public enum DBE525001SelectChohyoType implements Serializable {

    /**
     * 要介護認定判定結果一覧表A3版
     */
    要介護認定判定結果一覧表A3版(ReportIdDBE.DBE525002.getReportId().value(), ReportIdDBE.DBE525002.getReportName()),
    /**
     * 要介護認定判定結果一覧表
     */
    要介護認定判定結果一覧表(ReportIdDBE.DBE525001.getReportId().value(), ReportIdDBE.DBE525001.getReportName()),
    /**
     * 要介護認定審査判定結果_鑑
     */
    要介護認定審査判定結果_鑑(ReportIdDBE.DBE525006.getReportId().value(), ReportIdDBE.DBE525006.getReportName()),
    /**
     * 要介護認定審査会議事録
     */
    要介護認定審査会議事録(ReportIdDBE.DBE525003.getReportId().value(), ReportIdDBE.DBE525003.getReportName()),
    /**
     * 要介護認定結果通知一覧表
     */
    要介護認定結果通知一覧表(ReportIdDBE.DBE525004.getReportId().value(), ReportIdDBE.DBE525004.getReportName());
    private final RString キー;
    private final RString 帳票名称;

    private DBE525001SelectChohyoType(RString キー, RString 帳票名称) {
        this.キー = キー;
        this.帳票名称 = 帳票名称;
    }

    /**
     * キーを返します。
     *
     * @return {@link RString}
     */
    public RString getKey() {
        return this.キー;
    }

    /**
     * 帳票名称を返します。
     *
     * @return {@link RString}
     */
    public RString get帳票名称() {
        return this.帳票名称;
    }
}

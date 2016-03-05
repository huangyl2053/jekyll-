/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票IDを定義する列挙型です。
 */
public enum ItakusakiChosainIchiranReportId {

    /**
     * 調査員一覧情報の帳票ID。
     */
    REPORT_ID("DBE592001"),
    /**
     * 要介護認定業務進捗状況一覧表の帳票ID。
     */
    REPORTID_DBE521002("DBE521002"),
    /**
     * 要介護認定結果情報提供票（主治医）の帳票ID。
     */
    REPORTID_DBE090001("DBE090001"),
    /**
     * 認定調査スケジュール表(調査員)の帳票ID。
     */
    REPORTID_DBE202001("DBE202001"),
    /**
     * 認定調査スケジュール表(時間管理)の帳票ID。
     */
    REPORTID_DBE202011("DBE202011"),
    /**
     * 主治医意見書提出督促状の帳票ID。
     */
    REPORTID_DBE233001("DBE233001"),
    /**
     * 主治医意見書督促対象者一覧表の帳票ID。
     */
    REPORTID_DBE233002("DBE233002"),
    /**
     * 要介護認定調査依頼書の帳票ID。
     */
    REPORTID_DBE220001("BE220001_ChosaIraisho"),
    /**
     * 介護認定審査会スケジュール表かがみの帳票ID。
     */
    REPORTID_DBE514002("DBE514002_Shinsaschedulekagami"),
    /**
     * 介護認定審査会スケジュール表の帳票ID。
     */
    REPORTID_DBE514001("DBE514001_shinsakaisukejuruhyo");

    private final RString code;

    private ItakusakiChosainIchiranReportId(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * name()と同じ文字列をRString型で返します。
     *
     * @return name()と同じ文字列を持ったRString
     */
    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 該当する列挙型がない場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static JyoukyouType toValue(RString code) {
        for (JyoukyouType target : JyoukyouType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("除外対象の列挙型(" + code.toString() + ")").toString());
    }

}

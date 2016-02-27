/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 広域内住所地特例者一覧表のReportIdの列挙型です。
 */
public enum KoikinaiJushochiTokureiEnum {

    /**
     *  広域内住所地特例者一覧表のReportId
     */
    ReportId("DBU1140010", "ReportId");

    private final RString code;
    private final RString fullName;

    private KoikinaiJushochiTokureiEnum(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域内住所地特例者一覧表のReportIdを返します。
     *
     * @return 意見書・症状としての安定性のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域内住所地特例者一覧表のReportIdの名称を返します。
     *
     * @return 意見書・症状としての安定性の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域内住所地特例者一覧表のReportIdと一致する内容を探します。
     *
     * @param code 広域内住所地特例者一覧表のReportId
     * @return {@code code} に対応する広域内住所地特例者一覧表のReportId
     */
    public static KoikinaiJushochiTokureiEnum toValue(RString code) {
        for (KoikinaiJushochiTokureiEnum anteisei : KoikinaiJushochiTokureiEnum.values()) {
            if (anteisei.code.equals(code)) {
                return anteisei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書・症状としての安定性"));
    }

}

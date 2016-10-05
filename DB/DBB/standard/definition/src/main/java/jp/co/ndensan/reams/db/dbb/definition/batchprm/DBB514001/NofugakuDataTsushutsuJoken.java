/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Entityクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NofugakuDataTsushutsuJoken implements Serializable {

    private static final long serialVersionUID = 1L;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 集計日区分;
    private RDate 抽出開始日;
    private RDate 抽出終了日;

    /**
     * コンストラクタです。
     */
    public NofugakuDataTsushutsuJoken() {
    }

    /**
     * コンストラクタです。
     *
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 集計日区分 RString
     * @param 抽出開始日 RDate
     * @param 抽出終了日 RDate
     */
    public NofugakuDataTsushutsuJoken(LasdecCode 市町村コード, RString 市町村名称, RString 集計日区分,
            RDate 抽出開始日, RDate 抽出終了日) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.集計日区分 = 集計日区分;
        this.抽出開始日 = 抽出開始日;
        this.抽出終了日 = 抽出終了日;
    }
}

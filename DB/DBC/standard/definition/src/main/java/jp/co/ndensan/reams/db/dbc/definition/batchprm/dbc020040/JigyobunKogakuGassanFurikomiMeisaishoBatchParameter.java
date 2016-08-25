/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020040;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNN2004_事業合算・事業分振込明細書作成（一括）バッチパラメータクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunKogakuGassanFurikomiMeisaishoBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    @BatchParameter(key = "支払方法", name = "支払方法")
    private RString 支払方法;

    @BatchParameter(key = "今回対象年月日From", name = "今回対象年月日From")
    private RDate 今回対象年月日From;

    @BatchParameter(key = "今回対象年月日To", name = "今回対象年月日To")
    private RDate 今回対象年月日To;

    @BatchParameter(key = "出力帳票", name = "出力帳票")
    private RString 出力帳票;

    @BatchParameter(key = "FDDataを作成する", name = "FDDataを作成する")
    private boolean FDDataを作成する;

    @BatchParameter(key = "作成日 ", name = "作成日 ")
    private RString 作成日;

    @BatchParameter(key = "依頼日 ", name = "依頼日 ")
    private RDate 依頼日;

    @BatchParameter(key = "振込指定日 ", name = "振込指定日 ")
    private RDate 振込指定日;

    @BatchParameter(key = "発行対象 ", name = "発行対象 ")
    private RString 発行対象;

    @BatchParameter(key = "出力順設定リスト ", name = "出力順設定リスト ")
    private RString 出力順設定リスト;

    @BatchParameter(key = "取引先金融機関 ", name = "取引先金融機関 ")
    private RString 取引先金融機関;

    @BatchParameter(key = "取引先金融機関支店名称 ", name = "取引先金融機関支店名称 ")
    private RString 取引先金融機関支店名称;

    @BatchParameter(key = "対象作成年月日 ", name = "対象作成年月日 ")
    private RDate 対象作成年月日;
}

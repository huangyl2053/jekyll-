/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetArea;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetYearMonth;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010.TokuchiJissekiKanriListSakuseiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3880-050 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchiJissekiKanriListSakuseiProcessParameter implements IBatchProcessParameter {

    private TargetYearMonth 対象年月;
    private FlexibleYearMonth 年月範囲の開始;
    private FlexibleYearMonth 年月範囲の終了;
    private RString 事業者番号;
    private TargetArea 地区コード種類;
    private RString 開始地区コード;
    private RString 終了地区コード;
    private LasdecCode 市町村コード;
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象年月 対象年月
     * @param 年月範囲の開始 年月範囲の開始
     * @param 年月範囲の終了 年月範囲の終了
     * @param 事業者番号 事業者番号
     * @param 地区コード種類 地区コード種類
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 市町村コード 市町村コード
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     */
    public TokuchiJissekiKanriListSakuseiProcessParameter(TargetYearMonth 対象年月,
            FlexibleYearMonth 年月範囲の開始, FlexibleYearMonth 年月範囲の終了, RString 事業者番号,
            TargetArea 地区コード種類, RString 開始地区コード, RString 終了地区コード, LasdecCode 市町村コード, Long 改頁出力順ID, ReportId 帳票ID) {
        this.対象年月 = 対象年月;
        this.年月範囲の開始 = 年月範囲の開始;
        this.年月範囲の終了 = 年月範囲の終了;
        this.事業者番号 = 事業者番号;
        this.地区コード種類 = 地区コード種類;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.市町村コード = 市町村コード;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = RDate.getNowDateTime();
    }

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return 給付実績参照キー作成のMyBatis用パラメー
     */
    public TokuchiJissekiKanriListSakuseiMybatisParameter toTokuchiJissekiKanriListSakuseiMybatisParameter(RString psmShikibetsuTaisho, RString 出力順) {
        return new TokuchiJissekiKanriListSakuseiMybatisParameter(地区コード種類, 開始地区コード, 終了地区コード, 市町村コード, psmShikibetsuTaisho, 出力順);
    }
}

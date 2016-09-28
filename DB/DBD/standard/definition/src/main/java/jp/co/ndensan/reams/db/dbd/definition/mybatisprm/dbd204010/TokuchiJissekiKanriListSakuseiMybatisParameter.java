/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetArea;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3880-050 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchiJissekiKanriListSakuseiMybatisParameter implements IMyBatisParameter {

    private RString 対象年月;
    private FlexibleYearMonth 年月範囲の開始;
    private FlexibleYearMonth 年月範囲の終了;
    private JigyoshaNo 事業者番号;
    private RString 地区コード種類;
    private RString 開始地区コード;
    private RString 終了地区コード;
    private LasdecCode 市町村コード;
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;
    private RString 出力順;
    private RString psmShikibetsuTaisho;
    private boolean is地区コード = false;
    private boolean is地区_住所 = false;
    private boolean is地区_行政区 = false;
    private boolean is地区_地区 = false;
    private boolean is地区_全て = false;
    private boolean is市町村コード_非空 = false;
    private static final RString 住所 = new RString("1");
    private static final RString 行政区 = new RString("2");
    private static final RString 地区 = new RString("3");
    private static final RString 全て = new RString("0");

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 地区コード種類 地区コード種類
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 市町村コード 市町村コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     */
    public TokuchiJissekiKanriListSakuseiMybatisParameter(
            TargetArea 地区コード種類, RString 開始地区コード, RString 終了地区コード,
            LasdecCode 市町村コード, RString psmShikibetsuTaisho, RString 出力順) {
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.市町村コード = 市町村コード;
        edit地区コード(地区コード種類);
        edit地区コード種類(地区コード種類);
        edit市町村コード(市町村コード);
        this.出力順 = 出力順;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    private void edit地区コード(TargetArea 地区コード種類) {
        if (地区コード種類 != null) {
            is地区コード = true;
        }
    }

    private void edit地区コード種類(TargetArea 地区コード種類) {
        if (地区コード種類 != null) {
            if (地区コード種類.getコード().equals(住所)) {
                is地区_住所 = true;
            } else if (地区コード種類.getコード().equals(行政区)) {
                is地区_行政区 = true;
            } else if (地区コード種類.getコード().equals(地区)) {
                is地区_地区 = true;
            } else if (地区コード種類.getコード().equals(全て)) {
                is地区_全て = true;
            }
        }
    }

    private void edit市町村コード(LasdecCode 市町村コード) {
        if (市町村コード != null && !市町村コード.isEmpty()) {
            is市町村コード_非空 = true;
        }
    }
}

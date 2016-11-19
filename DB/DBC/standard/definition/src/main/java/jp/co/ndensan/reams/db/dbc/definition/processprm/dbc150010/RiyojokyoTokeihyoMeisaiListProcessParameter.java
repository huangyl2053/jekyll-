/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_MeisaiGokeiOutKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_TaishoNengetsu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.CreateRiyojokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.KyufuJissekiKihonMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.ToukeiJukyushaTaichoDataSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用状況統計表（明細リスト）作成のProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyojokyoTokeihyoMeisaiListProcessParameter implements IBatchProcessParameter {

    private static final RString 全て指定 = new RString("000000");
    private static final RString 地区指定_町域 = new RString("1");
    private static final RString 地区指定_行政区 = new RString("2");
    private static final RString 地区指定_地区1 = new RString("3");
    private static final RString 地区指定_地区2 = new RString("4");
    private static final RString 地区指定_地区3 = new RString("4");
    private static final RString 居宅利用率_指定 = new RString("1");
    private RString 対象年月;
    private FlexibleYearMonth 開始年月;
    private FlexibleYearMonth 終了年月;
    private HihokenshaNo 被保険者番号;
    private JigyoshaNo 事業者番号;
    private RString 導入形態コード;
    private RString 市町村コード;
    private RString 旧市町村コード;
    private RString 居宅利用率指定;
    private RString 開始居宅利用率;
    private RString 終了居宅利用率;

    private RString 訪問利用率指定;
    private RString 開始訪問利用率;
    private RString 終了訪問利用率;
    private RString 明細合計出力区分;

    private RString 地区指定;
    private Map<RString, RString> 選択地区リスト;
    private RString 利用実績区分;
    private RString 旧市町村名称;
    private RString 出力順ID;

    /**
     * 給付実績基本データ取得のMyBatisParameterを作成します。
     *
     * @return {@link KyufuJissekiKihonMybatisParameter}
     */
    public KyufuJissekiKihonMybatisParameter toMybatisParameter() {
        boolean is被保険者番号 = false;
        boolean is事業者番号 = false;
        boolean isサービス提供年月 = false;
        boolean is審査年月 = false;
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            is被保険者番号 = true;
        }
        if (事業者番号 != null && !事業者番号.isEmpty()) {
            is事業者番号 = true;
        }
        if (Tokeihyo_TaishoNengetsu.サービス提供年月.getコード().equals(対象年月)) {
            isサービス提供年月 = true;
        } else {
            is審査年月 = true;
        }
        return new KyufuJissekiKihonMybatisParameter(開始年月, 終了年月,
                被保険者番号, 事業者番号, is被保険者番号, is事業者番号, isサービス提供年月, is審査年月);
    }

    /**
     * 給付実績基本データ取得のMyBatisParameterを作成します。
     *
     * @return {@link ToukeiJukyushaTaichoDataSakuseiMybatisParameter}
     */
    public ToukeiJukyushaTaichoDataSakuseiMybatisParameter toToukeiJukyushaTaichoDataSakuseiMybatisParameter() {
        return new ToukeiJukyushaTaichoDataSakuseiMybatisParameter(開始年月, 終了年月);
    }

    /**
     * 出力対象データ取得のMyBatisParameterを作成します。
     *
     * @return {@link CreateRiyojokyoMybatisParameter}
     */
    public CreateRiyojokyoMybatisParameter toCreateRiyojokyoMybatisParameter() {
        boolean has市町村コード = false;
        boolean has旧市町村コード = false;
        boolean has行政区 = false;
        boolean has地区1 = false;
        boolean has地区2 = false;
        boolean has地区3 = false;
        boolean is集計 = false;
        boolean is明細 = false;
        if (地区指定_行政区.equals(地区指定)) {
            has行政区 = true;
        }
        if (地区指定_地区1.equals(地区指定)) {
            has地区1 = true;
        }
        if (地区指定_地区2.equals(地区指定)) {
            has地区2 = true;
        }
        if (地区指定_地区3.equals(地区指定)) {
            has地区3 = true;
        }
        if ((RString.isNullOrEmpty(市町村コード) && !RString.isNullOrEmpty(旧市町村コード) && !全て指定.equals(旧市町村コード))
                || (!RString.isNullOrEmpty(市町村コード) && !全て指定.equals(市町村コード)
                && !RString.isNullOrEmpty(旧市町村コード) && !全て指定.equals(旧市町村コード))) {
            has旧市町村コード = true;
        }
        if ((!RString.isNullOrEmpty(市町村コード) && !全て指定.equals(市町村コード))
                && (RString.isNullOrEmpty(旧市町村コード) || 全て指定.equals(旧市町村コード))) {
            has市町村コード = true;
        }
        if (RiyojokyoTokeihyo_MeisaiGokeiOutKubun.明細のみ.getコード().equals(明細合計出力区分)) {
            is明細 = true;
        } else if (RiyojokyoTokeihyo_MeisaiGokeiOutKubun.明細合計.getコード().equals(明細合計出力区分)) {
            is集計 = true;
        }

        List<RString> 地区リスト = new ArrayList<>();
        for (RString 地区 : 選択地区リスト.keySet()) {
            地区リスト.add(地区);
        }
        return new CreateRiyojokyoMybatisParameter(居宅利用率指定, 開始居宅利用率, 終了居宅利用率, 訪問利用率指定, 終了訪問利用率,
                開始訪問利用率, 市町村コード, 旧市町村コード, 地区指定, 地区リスト, !居宅利用率_指定.equals(居宅利用率指定),
                居宅利用率_指定.equals(居宅利用率指定), has市町村コード, has旧市町村コード,
                地区指定_町域.equals(訪問利用率指定), has行政区, has地区1, has地区2, has地区3, is集計, is明細, false, false, 利用実績区分);
    }
}

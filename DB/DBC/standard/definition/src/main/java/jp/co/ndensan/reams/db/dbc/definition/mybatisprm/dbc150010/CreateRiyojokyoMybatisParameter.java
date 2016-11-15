/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_DataKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 統計表作成のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class CreateRiyojokyoMybatisParameter implements IMyBatisParameter {

    private RString 居宅利用率指定;
    private RString 開始居宅利用率;
    private RString 終了居宅利用率;
    private RString 利用実績区分;
    private RString 訪問利用率指定;
    private RString 終了訪問利用率;
    private RString 開始訪問利用率;
    private RString 市町村コード;
    private RString 旧市町村コード;
    private RString 地区指定;
    private List<RString> 選択地区リスト;

    private boolean has訪問利用率;
    private boolean has居宅利用率;
    private boolean has市町村コード;
    private boolean has旧市町村コード;
    private boolean has町域;
    private boolean has行政区;
    private boolean has地区1;
    private boolean has地区2;
    private boolean has地区3;
    private boolean is集計;
    private boolean is明細;
    private boolean is事業者名;
    private boolean is給付事業者名;
    private final RString shukei = RiyojokyoTokeihyo_DataKubun.合計.getコード();
    private final RString meisai = RiyojokyoTokeihyo_DataKubun.明細.getコード();
    private final RString isTrue = new RString("1");
    private final RString isFalse = new RString("0");
    // TODO
//    private final RString 準拠しない = KihonJohoJunkyoKubun.準拠しない.getコード();
    private final RString junkyoShinai = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param 居宅利用率指定 居宅利用率指定
     * @param 開始居宅利用率 開始居宅利用率
     * @param 終了居宅利用率 終了居宅利用率
     * @param 訪問利用率指定 訪問利用率指定
     * @param 終了訪問利用率 終了訪問利用率
     * @param 開始訪問利用率 開始訪問利用率
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param 地区指定 地区指定
     * @param 選択地区リスト 選択地区リスト
     * @param has訪問利用率 訪問利用率かどうか
     * @param has居宅利用率 居宅利用率かどうか
     * @param has市町村コード 市町村コード存在かどうか
     * @param has旧市町村コード 旧市町村コード存在かどうか
     * @param has町域 地区指定＝1：町域
     * @param has行政区 地区指定＝2：行政区
     * @param has地区1 地区指定＝3：地区1
     * @param has地区2 地区指定＝4：地区2
     * @param has地区3 地区指定＝5：地区3
     * @param is集計 明細合計出力区分＝3：合計
     * @param is明細 明細合計出力区分＝2：明細
     * @param is事業者名 事業者名取得
     * @param is給付事業者名 給付事業者名取得
     * @param 利用実績区分 利用実績区分
     */
    public CreateRiyojokyoMybatisParameter(RString 居宅利用率指定, RString 開始居宅利用率, RString 終了居宅利用率,
            RString 訪問利用率指定, RString 終了訪問利用率, RString 開始訪問利用率, RString 市町村コード, RString 旧市町村コード,
            RString 地区指定, List<RString> 選択地区リスト, boolean has訪問利用率, boolean has居宅利用率, boolean has市町村コード,
            boolean has旧市町村コード, boolean has町域, boolean has行政区, boolean has地区1, boolean has地区2,
            boolean has地区3, boolean is集計, boolean is明細, boolean is事業者名, boolean is給付事業者名, RString 利用実績区分) {
        this.居宅利用率指定 = 居宅利用率指定;
        this.開始居宅利用率 = 開始居宅利用率;
        this.終了居宅利用率 = 終了居宅利用率;
        this.訪問利用率指定 = 訪問利用率指定;
        this.終了訪問利用率 = 終了訪問利用率;
        this.開始訪問利用率 = 開始訪問利用率;
        this.市町村コード = 市町村コード;
        this.旧市町村コード = 旧市町村コード;
        this.地区指定 = 地区指定;
        this.選択地区リスト = 選択地区リスト;
        this.has訪問利用率 = has訪問利用率;
        this.has居宅利用率 = has居宅利用率;
        this.has市町村コード = has市町村コード;
        this.has旧市町村コード = has旧市町村コード;
        this.has町域 = has町域;
        this.has行政区 = has行政区;
        this.has地区1 = has地区1;
        this.has地区2 = has地区2;
        this.has地区3 = has地区3;
        this.is集計 = is集計;
        this.is明細 = is明細;
        this.is事業者名 = is事業者名;
        this.is給付事業者名 = is給付事業者名;
        this.利用実績区分 = 利用実績区分;
    }

    /**
     * コンストラクタです。
     */
    public CreateRiyojokyoMybatisParameter() {
    }
}

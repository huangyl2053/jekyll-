package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;

import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。

 * @reamsid_L DBA-1610-040 dingyi
 */
public interface IHanyoListAtenaSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * 汎用リスト宛名抽出条件共有子Divを初期化します(パラメータがある)。
     *
     * @param 保険者構成 保険者構成
     */
    public void initialize(HokenshaKosei 保険者構成);

    /**
     * 汎用リスト宛名抽出条件共有子Divを初期化します(パラメータがなし)。
     */
    public void initialize();

    /**
     * 汎用リスト宛名抽出条件共有子Divの抽出条件ラジオボタンの設定値を返却します。
     *
     * @return 年齢層抽出方法抽出条件ラジオボタンの設定値
     */
    public NenreiSoChushutsuHoho get年齢層抽出方法();

    /**
     * 汎用リスト宛名抽出条件共有子Divの抽出条件ラジオボタンの値を設定します。
     *
     * @param 年齢層抽出方法
     */
    public void set年齢層抽出方法(RString 年齢層抽出方法);

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢開始の設定値を返却します。
     *
     * @return 年齢開始の設定値
     */
    public Decimal get年齢開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢開始の値を設定します。
     *
     * @param 年齢開始
     */
    public void set年齢開始(Decimal 年齢開始);

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の設定値を返却します。
     *
     * @return 年齢終了の設定値
     */
    public Decimal get年齢終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の値を設定します。
     *
     * @param 年齢終了
     */
    public void set年齢終了(Decimal 年齢終了);

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢基準日の設定値を返却します。
     *
     * @return 年齢基準日の設定値
     */
    public RDate get年齢基準日();

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢基準日の値を設定します。
     *
     * @param 年齢基準日
     */
    public void set年齢基準日(RDate 年齢基準日);

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日開始の設定値を返却します。
     *
     * @return 生年月日開始の設定値
     */
    public RDate get生年月日開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日開始の値を設定します。
     *
     * @param 生年月日開始
     */
    public void set生年月日開始(RDate 生年月日開始);

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日終了の設定値を返却します。
     *
     * @return 生年月日終了の設定値
     */
    public RDate get生年月日終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日終了の値を設定します。
     *
     * @param 生年月日終了
     */
    public void set生年月日終了(RDate 生年月日終了);

    /**
     * 汎用リスト宛名抽出条件共有子Divの保険者の設定値を返却します。
     *
     * @return 保険者の設定値
     */
    public HokenshaSummary get保険者();

    /**
     * 汎用リスト宛名抽出条件共有子Divの保険者の値を設定します。
     */
    public void set保険者();

    /**
     * 汎用リスト宛名抽出条件共有子Divの保険者の値（選択項）を設定します。
     *
     * @param 市町村コード
     */
    public void set保険者(LasdecCode 市町村コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区ラジオボタンの設定値を返却します。
     *
     * @return 地区ラジオボタンの設定値
     */
    public Chiku get地区();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区の値を設定します。
     *
     * @param 地区
     */
    public void set地区(RString 地区);

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所開始の設定値を返却します。
     *
     * @return 住所開始の設定値
     */
    public RString get住所開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所開始の値を設定します。
     *
     * @param 町域コード
     */
    public void set住所開始(ChoikiCode 町域コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区開始の設定値を返却します。
     *
     * @return 行政区開始の設定値
     */
    public RString get行政区開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区開始の値を設定します。
     *
     * @param 行政区コード
     */
    public void set行政区開始(GyoseikuCode 行政区コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１開始の設定値を返却します。
     *
     * @return 地区１開始の設定値
     */
    public RString get地区１開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１開始の値を設定します。
     *
     * @param 地区1コード
     */
    public void set地区１開始(ChikuCode 地区1コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２開始の設定値を返却します。
     *
     * @return 地区２開始の設定値
     */
    public RString get地区２開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２開始の値を設定します。
     *
     * @param 地区2コード
     */
    public void set地区２開始(ChikuCode 地区2コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３開始の設定値を返却します。
     *
     * @return 地区３開始の設定値
     */
    public RString get地区３開始();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３開始の値を設定します。
     *
     * @param 地区3コード
     */
    public void set地区３開始(ChikuCode 地区3コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所終了の設定値を返却します。
     *
     * @return 住所終了の設定値
     */
    public RString get住所終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所終了の値を設定します。
     *
     * @param 町域コード
     */
    public void set住所終了(ChoikiCode 町域コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区終了の設定値を返却します。
     *
     * @return 行政区終了の設定値
     */
    public RString get行政区終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区終了の値を設定します。
     *
     * @param 行政区コード
     */
    public void set行政区終了(GyoseikuCode 行政区コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１終了の設定値を返却します。
     *
     * @return 地区１終了の設定値
     */
    public RString get地区１終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１終了の値を設定します。
     *
     * @param 地区1コード
     */
    public void set地区１終了(ChikuCode 地区1コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２終了の設定値を返却します。
     *
     * @return 地区２終了の設定値
     */
    public RString get地区２終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２終了の値を設定します。
     *
     * @param 地区2コード
     */
    public void set地区２終了(ChikuCode 地区2コード);

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３終了の設定値を返却します。
     *
     * @return 地区３終了の設定値
     */
    public RString get地区３終了();

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３終了の値を設定します。
     *
     * @param 地区3コード
     */
    public void set地区３終了(ChikuCode 地区3コード);

    /**
     * 宛名の抽出条件を作成して返却します。
     *
     * @return 宛名の抽出条件
     */
    public AtenaSelectBatchParameter get宛名抽出条件();

    /**
     * 宛名抽出条件子Divを返却します。
     *
     * @return 宛名抽出条件子Div
     */
    public HanyoListAtenaSelectDiv get宛名抽出条件子Div();

}

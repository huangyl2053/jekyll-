/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-040 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JogaiTokureiSyaJyohouMybatisParameter implements IMyBatisParameter {

    private final RString 自特例適用;
    private final RString 自特例転入;
    private final RString 自特例解除;
    private final FlexibleDate システム日付;
    private final FlexibleDate 事業所抽出開始年月日;
    private final FlexibleDate 事業所抽出終了年月日;
    private final RDateTime 対象開始日時;
    private final RDateTime 対象終了日時;
    private final HihokenshaNo 被保険者番号;
    private final RString 特定個人情報版管理番号04;
    private final RString 住所地特例情報_0102;
    private final RString 版番号;
    private final RString 提供区分_個人番号未設定;
    private final RString 提供区分_その他エラー;
    private final RString 台帳種別;
    private final boolean is当初または版改定;
    private final boolean is再登録;
    private final boolean is異動;
    private final RString psmShikibetsuTaisho;

    private JogaiTokureiSyaJyohouMybatisParameter(RString 自特例適用,
            RString 自特例転入,
            RString 自特例解除,
            FlexibleDate システム日付,
            FlexibleDate 事業所抽出開始年月日,
            FlexibleDate 事業所抽出終了年月日,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            HihokenshaNo 被保険者番号,
            RString 特定個人情報版管理番号04,
            RString 住所地特例情報_0102,
            RString 版番号,
            RString 提供区分_個人番号未設定,
            RString 提供区分_その他エラー,
            RString 台帳種別,
            boolean is当初または版改定,
            boolean is再登録,
            boolean is異動,
            RString psmShikibetsuTaisho) {
        this.自特例適用 = 自特例適用;
        this.自特例転入 = 自特例転入;
        this.自特例解除 = 自特例解除;
        this.システム日付 = システム日付;
        this.事業所抽出開始年月日 = 事業所抽出開始年月日;
        this.事業所抽出終了年月日 = 事業所抽出終了年月日;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
        this.被保険者番号 = 被保険者番号;
        this.特定個人情報版管理番号04 = 特定個人情報版管理番号04;
        this.住所地特例情報_0102 = 住所地特例情報_0102;
        this.版番号 = 版番号;
        this.提供区分_個人番号未設定 = 提供区分_個人番号未設定;
        this.提供区分_その他エラー = 提供区分_その他エラー;
        this.台帳種別 = 台帳種別;
        this.is当初または版改定 = is当初または版改定;
        this.is再登録 = is再登録;
        this.is異動 = is異動;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 当初/版改定／異動分データ抽出パラメータを生成します。
     *
     * @param 事業所抽出開始年月日 事業所抽出開始年月日
     * @param 事業所抽出終了年月日 事業所抽出終了年月日
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 被保険者番号 被保険者番号
     * @param 版番号 版番号
     * @param 新規異動区分 新規異動区分
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     *
     * @return 当初/版改定／異動分データ抽出のParamter
     */
    public static JogaiTokureiSyaJyohouMybatisParameter createParamter当初_版改定_異動分データ抽出(
            FlexibleDate 事業所抽出開始年月日,
            FlexibleDate 事業所抽出終了年月日,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            HihokenshaNo 被保険者番号,
            RString 版番号,
            RString 新規異動区分,
            RString psmShikibetsuTaisho) {
        boolean is当初または版改定 = false;
        boolean is再登録 = false;
        boolean is異動 = false;
        if (ShinkiIdoKubun.当初.getコード().equals(新規異動区分)
                || ShinkiIdoKubun.版改定.getコード().equals(新規異動区分)) {
            is当初または版改定 = true;
        }
        if (ShinkiIdoKubun.再登録.getコード().equals(新規異動区分)) {
            is再登録 = true;
        }
        if (ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            is異動 = true;
        }
        return new JogaiTokureiSyaJyohouMybatisParameter(
                ShikakuJutokuTekiyoJiyu.自特例適用.getコード(),
                ShikakuJutokuKaijoJiyu.自特例転入.getコード(),
                ShikakuJutokuKaijoJiyu.自特例解除.getコード(),
                new FlexibleDate(RDate.getNowDate().toDateString()),
                事業所抽出開始年月日,
                事業所抽出終了年月日,
                対象開始日時,
                対象終了日時,
                被保険者番号,
                TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                DataSetNo._0102住所地特例情報.getコード(),
                版番号,
                TeikyoKubun.個人番号未設定により未提供.getコード(),
                TeikyoKubun.その他エラーにより未提供.getコード(),
                DaichoType.被保険者.getコード(),
                is当初または版改定,
                is再登録,
                is異動,
                psmShikibetsuTaisho);
    }
}

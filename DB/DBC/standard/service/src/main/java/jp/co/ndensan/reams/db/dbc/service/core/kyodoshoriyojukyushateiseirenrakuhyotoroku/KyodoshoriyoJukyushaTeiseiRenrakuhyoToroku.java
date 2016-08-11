/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushateiseirenrakuhyotoroku;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKogakuSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者訂正連絡票登録（画面）のクラスです。
 *
 * @reamsid_L DBC-1951-040 chenaoqi
 */
public class KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku {

    private static final RString モード_訂正 = new RString("訂正");
    private static final RString モード_削除 = new RString("削除");
    private static final RString 訂正区分_訂正 = new RString("2");
    private static final RString 訂正区分_削除 = new RString("3");

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return // * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku}のインスタンス
     */
    public static KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku createInstance() {
        return InstanceProvider.create(KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku.class);
    }

    /**
     * 共同処理用受給者訂正連絡票データ作成のメソッドです
     *
     * @param divEntity 共同処理用受給者異動連絡票共有子Div
     * @param 画面モード RString
     * @param 初期化Entity 共有子Div初期化時に取得した共同処理用受給者異動情報Entity
     * @param 基本送付flag boolean
     * @param 償還送付flag boolean
     * @param 高額送付flag boolean
     * @return 出力用共同処理受給者訂正情報Entity
     */
    public KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity editKyodoshoriyoJukyushaTeiseiRenrakuhyo(
            KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity, RString 画面モード,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化Entity,
            boolean 基本送付flag, boolean 償還送付flag, boolean 高額送付flag) {
        if (divEntity == null || divEntity.get共通項目Entity() == null
                || 初期化Entity == null || 初期化Entity.get共通項目Entity() == null) {
            return null;
        }
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理受給者訂正情報Entity = new KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity();
        if (モード_訂正.equals(画面モード)
                && 訂正区分_訂正.equals(divEntity.get共通項目Entity().get訂正区分())) {
            出力用共同処理受給者訂正情報Entity = get訂正情報Entity(divEntity, 初期化Entity, 基本送付flag, 償還送付flag, 高額送付flag);

        } else if (モード_訂正.equals(画面モード)
                && 訂正区分_削除.equals(divEntity.get共通項目Entity().get訂正区分())) {
            出力用共同処理受給者訂正情報Entity.set作成年月日(FlexibleDate.getNowDate());
            出力用共同処理受給者訂正情報Entity.set証記載保険者番号(初期化Entity.get共通項目Entity().get証記載保険者番号());
            出力用共同処理受給者訂正情報Entity.set被保険者番号(初期化Entity.get共通項目Entity().get被保険者番号());
            出力用共同処理受給者訂正情報Entity.set異動区分(初期化Entity.get共通項目Entity().get異動区分());
            出力用共同処理受給者訂正情報Entity.set異動事由(初期化Entity.get共通項目Entity().get異動事由());
            出力用共同処理受給者訂正情報Entity.set訂正区分(divEntity.get共通項目Entity().get訂正区分());
            出力用共同処理受給者訂正情報Entity.set訂正年月日(divEntity.get共通項目Entity().get訂正年月日());
            if (初期化Entity.get基本情報Entity() != null) {

                出力用共同処理受給者訂正情報Entity.set基本送付情報_異動年月日(初期化Entity.get基本情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set氏名(初期化Entity.get基本情報Entity().get被保険者氏名());
                出力用共同処理受給者訂正情報Entity.set電話番号(初期化Entity.get基本情報Entity().get電話番号());
                出力用共同処理受給者訂正情報Entity.set郵便番号(初期化Entity.get基本情報Entity().get郵便番号());
                出力用共同処理受給者訂正情報Entity.set住所(初期化Entity.get基本情報Entity().get住所());
                出力用共同処理受給者訂正情報Entity.set住所カナ(初期化Entity.get基本情報Entity().get住所カナ());
                出力用共同処理受給者訂正情報Entity.set帳票出力順序コード(初期化Entity.get基本情報Entity().get帳票出力順序コード());
            }
            if (初期化Entity.get償還情報Entity() != null) {
                出力用共同処理受給者訂正情報Entity.set償還送付情報_異動年月日(初期化Entity.get償還情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set開始年月日(初期化Entity.get償還情報Entity().get保険給付支払一時差止開始年月日());
                出力用共同処理受給者訂正情報Entity.set終了年月日(初期化Entity.get償還情報Entity().get保険給付支払一時差止終了年月日());
                出力用共同処理受給者訂正情報Entity.set区分(初期化Entity.get償還情報Entity().get保険給付支払一時差止区分コード());
                出力用共同処理受給者訂正情報Entity.set一時差止金額(初期化Entity.get償還情報Entity().get保険給付支払一時差止金額());
            }
            if (初期化Entity.get高額情報Entity() != null) {
                出力用共同処理受給者訂正情報Entity.set高額送付情報_異動年月日(初期化Entity.get高額情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set世帯主被保険者番号(初期化Entity.get高額情報Entity().get世帯集約番号());
                出力用共同処理受給者訂正情報Entity.set世帯所得区分(初期化Entity.get高額情報Entity().get世帯所得区分コード());
                出力用共同処理受給者訂正情報Entity.set所得区分(初期化Entity.get高額情報Entity().get所得区分コード());
                出力用共同処理受給者訂正情報Entity.set利用者負担第２段階(初期化Entity.get高額情報Entity().is利用者負担第２段階有フラグ());
                出力用共同処理受給者訂正情報Entity.set老齢福祉年金受給の有無(初期化Entity.get高額情報Entity().is老齢福祉年金受給有フラグ());
                出力用共同処理受給者訂正情報Entity.set支給申請書出力の有無(初期化Entity.get高額情報Entity().is支給申請書出力有フラグ());
            }
        } else if (モード_削除.equals(画面モード)) {
            出力用共同処理受給者訂正情報Entity.set作成年月日(FlexibleDate.getNowDate());
            出力用共同処理受給者訂正情報Entity.set証記載保険者番号(初期化Entity.get共通項目Entity().get証記載保険者番号());
            出力用共同処理受給者訂正情報Entity.set被保険者番号(初期化Entity.get共通項目Entity().get被保険者番号());
            出力用共同処理受給者訂正情報Entity.set異動区分(初期化Entity.get共通項目Entity().get異動区分());
            出力用共同処理受給者訂正情報Entity.set異動事由(初期化Entity.get共通項目Entity().get異動事由());
            出力用共同処理受給者訂正情報Entity.set訂正区分(JukyushaIF_TeiseiKubunCode.修正.getコード());
            出力用共同処理受給者訂正情報Entity.set訂正年月日(FlexibleDate.getNowDate());
            if (初期化Entity.get基本情報Entity() != null) {

                出力用共同処理受給者訂正情報Entity.set基本送付情報_異動年月日(初期化Entity.get基本情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set氏名(初期化Entity.get基本情報Entity().get被保険者氏名());
                出力用共同処理受給者訂正情報Entity.set電話番号(初期化Entity.get基本情報Entity().get電話番号());
                出力用共同処理受給者訂正情報Entity.set郵便番号(初期化Entity.get基本情報Entity().get郵便番号());
                出力用共同処理受給者訂正情報Entity.set住所(初期化Entity.get基本情報Entity().get住所());
                出力用共同処理受給者訂正情報Entity.set住所カナ(初期化Entity.get基本情報Entity().get住所カナ());
                出力用共同処理受給者訂正情報Entity.set帳票出力順序コード(初期化Entity.get基本情報Entity().get帳票出力順序コード());
            }
            if (初期化Entity.get償還情報Entity() != null) {
                出力用共同処理受給者訂正情報Entity.set償還送付情報_異動年月日(初期化Entity.get償還情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set開始年月日(初期化Entity.get償還情報Entity().get保険給付支払一時差止開始年月日());
                出力用共同処理受給者訂正情報Entity.set終了年月日(初期化Entity.get償還情報Entity().get保険給付支払一時差止終了年月日());
                出力用共同処理受給者訂正情報Entity.set区分(初期化Entity.get償還情報Entity().get保険給付支払一時差止区分コード());
                出力用共同処理受給者訂正情報Entity.set一時差止金額(初期化Entity.get償還情報Entity().get保険給付支払一時差止金額());
            }
            if (初期化Entity.get高額情報Entity() != null) {
                出力用共同処理受給者訂正情報Entity.set高額送付情報_異動年月日(初期化Entity.get高額情報Entity().get異動年月日());
                出力用共同処理受給者訂正情報Entity.set世帯主被保険者番号(初期化Entity.get高額情報Entity().get世帯集約番号());
                出力用共同処理受給者訂正情報Entity.set世帯所得区分(初期化Entity.get高額情報Entity().get世帯所得区分コード());
                出力用共同処理受給者訂正情報Entity.set所得区分(初期化Entity.get高額情報Entity().get所得区分コード());
                出力用共同処理受給者訂正情報Entity.set利用者負担第２段階(初期化Entity.get高額情報Entity().is利用者負担第２段階有フラグ());
                出力用共同処理受給者訂正情報Entity.set老齢福祉年金受給の有無(初期化Entity.get高額情報Entity().is老齢福祉年金受給有フラグ());
                出力用共同処理受給者訂正情報Entity.set支給申請書出力の有無(初期化Entity.get高額情報Entity().is支給申請書出力有フラグ());
            }
        }
        return 出力用共同処理受給者訂正情報Entity;
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get訂正情報Entity(KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化Entity, boolean 基本送付flag, boolean 償還送付flag, boolean 高額送付flag) {
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理受給者訂正情報Entity = new KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity();
        出力用共同処理受給者訂正情報Entity.set作成年月日(FlexibleDate.getNowDate());
        出力用共同処理受給者訂正情報Entity.set証記載保険者番号(divEntity.get共通項目Entity().get証記載保険者番号());
        出力用共同処理受給者訂正情報Entity.set被保険者番号(divEntity.get共通項目Entity().get被保険者番号());
        出力用共同処理受給者訂正情報Entity.set異動区分(divEntity.get共通項目Entity().get異動区分());
        出力用共同処理受給者訂正情報Entity.set異動事由(divEntity.get共通項目Entity().get異動事由());
        if (divEntity.get基本情報Entity() != null) {
            出力用共同処理受給者訂正情報Entity.set基本送付情報_異動年月日(divEntity.get基本情報Entity().get異動年月日() != null
                    ? divEntity.get基本情報Entity().get異動年月日() : FlexibleDate.EMPTY);
        }
        if (divEntity.get償還情報Entity() != null) {
            出力用共同処理受給者訂正情報Entity.set償還送付情報_異動年月日(divEntity.get償還情報Entity().get異動年月日() != null
                    ? divEntity.get償還情報Entity().get異動年月日() : FlexibleDate.EMPTY);
        }
        if (divEntity.get高額情報Entity() != null) {
            出力用共同処理受給者訂正情報Entity.set高額送付情報_異動年月日(divEntity.get高額情報Entity().get異動年月日() != null
                    ? divEntity.get高額情報Entity().get異動年月日() : FlexibleDate.EMPTY);
        }
        出力用共同処理受給者訂正情報Entity.set訂正区分(divEntity.get共通項目Entity().get訂正区分());
        出力用共同処理受給者訂正情報Entity.set訂正年月日(divEntity.get共通項目Entity().get訂正年月日());
        出力用共同処理受給者訂正情報Entity = get基本情報Entity(divEntity, 初期化Entity, 出力用共同処理受給者訂正情報Entity, 基本送付flag);
        出力用共同処理受給者訂正情報Entity = get償還情報Entity(divEntity, 初期化Entity, 出力用共同処理受給者訂正情報Entity, 償還送付flag);
        出力用共同処理受給者訂正情報Entity = get高額情報Entity(divEntity, 初期化Entity, 出力用共同処理受給者訂正情報Entity, 高額送付flag);

        return 出力用共同処理受給者訂正情報Entity;
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get基本情報Entity(KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理受給者訂正情報Entity, boolean 基本送付flag) {
        if (divEntity == null || 初期化Entity == null || 出力用共同処理受給者訂正情報Entity == null) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        if (!基本送付flag) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        KyodoShoriyoJukyushaIdoKihonSofu 初期基本情報Entity = 初期化Entity.get基本情報Entity();
        KyodoShoriyoJukyushaIdoKihonSofu div基本情報Entity = divEntity.get基本情報Entity();
        if (初期基本情報Entity != null && div基本情報Entity != null) {
            RString 氏名 = 初期基本情報Entity.get被保険者氏名();
            if (氏名 != null
                    && !氏名.equals(divEntity.get基本情報Entity().get被保険者氏名())) {
                出力用共同処理受給者訂正情報Entity.set氏名(divEntity.get基本情報Entity().get被保険者氏名());
            } else {
                出力用共同処理受給者訂正情報Entity.set氏名(RString.EMPTY);
            }
            TelNo 電話番号 = 初期基本情報Entity.get電話番号();
            if (電話番号 != null
                    && !電話番号.equals(div基本情報Entity.get電話番号())) {
                出力用共同処理受給者訂正情報Entity.set電話番号(div基本情報Entity.get電話番号());
            } else {
                出力用共同処理受給者訂正情報Entity.set電話番号(TelNo.EMPTY);
            }
            YubinNo 郵便番号 = 初期基本情報Entity.get郵便番号();
            if (郵便番号 != null
                    && !郵便番号.equals(div基本情報Entity.get郵便番号())) {
                出力用共同処理受給者訂正情報Entity.set郵便番号(div基本情報Entity.get郵便番号());
            } else {
                出力用共同処理受給者訂正情報Entity.set郵便番号(YubinNo.EMPTY);
            }
            RString 住所 = 初期基本情報Entity.get住所();
            if (住所 != null
                    && !住所.equals(div基本情報Entity.get住所())) {
                出力用共同処理受給者訂正情報Entity.set住所(div基本情報Entity.get住所());
            } else {
                出力用共同処理受給者訂正情報Entity.set住所(RString.EMPTY);
            }
            RString 住所カナ = 初期基本情報Entity.get住所カナ();
            if (住所カナ != null
                    && !住所カナ.equals(div基本情報Entity.get住所カナ())) {
                出力用共同処理受給者訂正情報Entity.set住所カナ(div基本情報Entity.get住所カナ());
            } else {
                出力用共同処理受給者訂正情報Entity.set住所カナ(RString.EMPTY);
            }
            RString 帳票出力順序コード = 初期基本情報Entity.get帳票出力順序コード();
            if (帳票出力順序コード != null
                    && !帳票出力順序コード.equals(div基本情報Entity.get帳票出力順序コード())) {
                出力用共同処理受給者訂正情報Entity.set帳票出力順序コード(div基本情報Entity.get帳票出力順序コード());
            } else {
                出力用共同処理受給者訂正情報Entity.set帳票出力順序コード(RString.EMPTY);
            }
        }
        return 出力用共同処理受給者訂正情報Entity;

    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get償還情報Entity(KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理受給者訂正情報Entity, boolean 償還送付flag) {
        if (divEntity == null || 初期化Entity == null || 出力用共同処理受給者訂正情報Entity == null) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        if (!償還送付flag) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        KyodoShoriyoJukyushaIdoShokanSofu 初期償還情報Entity = 初期化Entity.get償還情報Entity();
        KyodoShoriyoJukyushaIdoShokanSofu div償還情報Entity = divEntity.get償還情報Entity();
        if (初期償還情報Entity != null && divEntity.get償還情報Entity() != null) {
            FlexibleDate 開始年月日 = 初期償還情報Entity.get保険給付支払一時差止開始年月日();
            if (開始年月日 != null
                    && !開始年月日.equals(初期償還情報Entity.get保険給付支払一時差止開始年月日())) {
                出力用共同処理受給者訂正情報Entity.set開始年月日(div償還情報Entity.get保険給付支払一時差止開始年月日());
            } else {
                出力用共同処理受給者訂正情報Entity.set開始年月日(FlexibleDate.EMPTY);
            }
            FlexibleDate 終了年月日 = 初期償還情報Entity.get保険給付支払一時差止終了年月日();
            if (終了年月日 != null
                    && !終了年月日.equals(div償還情報Entity.get保険給付支払一時差止終了年月日())) {
                出力用共同処理受給者訂正情報Entity.set終了年月日(div償還情報Entity.get保険給付支払一時差止終了年月日());
            } else {
                出力用共同処理受給者訂正情報Entity.set終了年月日(FlexibleDate.EMPTY);
            }
            RString 区分 = 初期償還情報Entity.get保険給付支払一時差止区分コード();
            if (区分 != null
                    && !区分.equals(div償還情報Entity.get保険給付支払一時差止区分コード())) {
                出力用共同処理受給者訂正情報Entity.set区分(div償還情報Entity.get保険給付支払一時差止区分コード());
            } else {
                出力用共同処理受給者訂正情報Entity.set区分(RString.EMPTY);
            }
            Decimal 一時差止金額 = 初期償還情報Entity.get保険給付支払一時差止金額();
            if (一時差止金額 != null
                    && !一時差止金額.equals(div償還情報Entity.get保険給付支払一時差止金額())) {
                出力用共同処理受給者訂正情報Entity.set一時差止金額(div償還情報Entity.get保険給付支払一時差止金額());
            } else {
                出力用共同処理受給者訂正情報Entity.set一時差止金額(null);
            }
        }

        return 出力用共同処理受給者訂正情報Entity;
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get高額情報Entity(KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理受給者訂正情報Entity, boolean 高額送付flag) {
        if (divEntity == null || 初期化Entity == null || 出力用共同処理受給者訂正情報Entity == null) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        if (!高額送付flag) {
            return 出力用共同処理受給者訂正情報Entity;
        }
        KyodoShoriyoJukyushaIdoKogakuSofu 初期高額情報Entity = 初期化Entity.get高額情報Entity();
        KyodoShoriyoJukyushaIdoKogakuSofu div高額情報Entity = divEntity.get高額情報Entity();
        if ((初期高額情報Entity != null && div高額情報Entity != null)) {
            HihokenshaNo 世帯主被保険者番号 = 初期高額情報Entity.get世帯集約番号();
            if (世帯主被保険者番号 != null
                    && !世帯主被保険者番号.equals(div高額情報Entity.get世帯集約番号())) {
                出力用共同処理受給者訂正情報Entity.set世帯主被保険者番号(div高額情報Entity.get世帯集約番号());
            } else {
                出力用共同処理受給者訂正情報Entity.set世帯主被保険者番号(HihokenshaNo.EMPTY);
            }
            RString 世帯所得区分 = 初期高額情報Entity.get世帯所得区分コード();
            if (世帯所得区分 != null
                    && !世帯所得区分.equals(div高額情報Entity.get世帯所得区分コード())) {
                出力用共同処理受給者訂正情報Entity.set世帯所得区分(div高額情報Entity.get世帯所得区分コード());
            } else {
                出力用共同処理受給者訂正情報Entity.set世帯所得区分(RString.EMPTY);
            }
            RString 所得区分 = 初期高額情報Entity.get世帯所得区分コード();
            if (所得区分 != null
                    && !所得区分.equals(div高額情報Entity.get世帯所得区分コード())) {
                出力用共同処理受給者訂正情報Entity.set所得区分(div高額情報Entity.get世帯所得区分コード());
            } else {
                出力用共同処理受給者訂正情報Entity.set所得区分(RString.EMPTY);
            }
            出力用共同処理受給者訂正情報Entity.set利用者負担第２段階(div高額情報Entity.is利用者負担第２段階有フラグ());
            出力用共同処理受給者訂正情報Entity.set老齢福祉年金受給の有無(div高額情報Entity.is老齢福祉年金受給有フラグ());
            出力用共同処理受給者訂正情報Entity.set支給申請書出力の有無(div高額情報Entity.is支給申請書出力有フラグ());
        }

        return 出力用共同処理受給者訂正情報Entity;
    }
}

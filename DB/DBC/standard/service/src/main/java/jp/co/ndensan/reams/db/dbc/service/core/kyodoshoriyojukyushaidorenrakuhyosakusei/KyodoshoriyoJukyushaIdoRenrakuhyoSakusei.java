/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyosakusei;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKogakuSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyoutuuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票作成（画面）
 *
 * @reamsid_L DBC-1952-020 chenaoqi
 */
public class KyodoshoriyoJukyushaIdoRenrakuhyoSakusei {

    /**
     * コンストラクタです。
     */
    KyodoshoriyoJukyushaIdoRenrakuhyoSakusei() {
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link KyodoshoriyoJukyushaIdoRenrakuhyoSakusei}
     */
    public static KyodoshoriyoJukyushaIdoRenrakuhyoSakusei createInstance() {
        return InstanceProvider.create(KyodoshoriyoJukyushaIdoRenrakuhyoSakusei.class);
    }

    /**
     * 共同処理用受給者異動連絡票データ作成
     *
     * @param divEntity 共同処理用受給者異動連絡票作成Div
     * @return 共同処理用受給者異動連絡票Entity
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity editKyodoshoriyoJukyushaIdoRenrakuhyo(
            KyodoshoriyoJukyushaIdoRenrakuhyoParam divEntity) {
        if (divEntity == null) {
            return null;
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity 共同処理用受給者異動連絡票Entity = new KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity();
        KyoutuuEntity 共通項目 = divEntity.get共通項目Entity();
        KyodoShoriyoJukyushaIdoKihonSofu 基本情報 = divEntity.get基本情報Entity();
        KyodoShoriyoJukyushaIdoShokanSofu 償還情報 = divEntity.get償還情報Entity();
        KyodoShoriyoJukyushaIdoKogakuSofu 高額情報 = divEntity.get高額情報Entity();
        if (共通項目 != null) {
            共同処理用受給者異動連絡票Entity.set作成年月日(FlexibleDate.getNowDate());
            共同処理用受給者異動連絡票Entity.set証記載保険者番号(共通項目.get証記載保険者番号());
            共同処理用受給者異動連絡票Entity.set被保険者番号(共通項目.get被保険者番号());
            共同処理用受給者異動連絡票Entity.set異動区分(共通項目.get異動区分());
            共同処理用受給者異動連絡票Entity.set異動事由(共通項目.get異動事由());
            共同処理用受給者異動連絡票Entity.set訂正区分(共通項目.get訂正区分());
            共同処理用受給者異動連絡票Entity.set訂正年月日(共通項目.get訂正年月日());
        }
        if (基本情報 != null) {
            共同処理用受給者異動連絡票Entity.set氏名(基本情報.get被保険者氏名());
            共同処理用受給者異動連絡票Entity.set基本送付情報_異動年月日(基本情報.get異動年月日());
            共同処理用受給者異動連絡票Entity.set電話番号(基本情報.get電話番号());
            共同処理用受給者異動連絡票Entity.set郵便番号(基本情報.get郵便番号());
            共同処理用受給者異動連絡票Entity.set住所(基本情報.get住所());
            共同処理用受給者異動連絡票Entity.set住所カナ(基本情報.get住所カナ());
            共同処理用受給者異動連絡票Entity.set帳票出力順序コード(基本情報.get帳票出力順序コード());
        }
        if (償還情報 != null) {
            共同処理用受給者異動連絡票Entity.set償還送付情報_異動年月日(償還情報.get異動年月日());
            共同処理用受給者異動連絡票Entity.set開始年月日(償還情報.get保険給付支払一時差止開始年月日());
            共同処理用受給者異動連絡票Entity.set終了年月日(償還情報.get保険給付支払一時差止終了年月日());
            共同処理用受給者異動連絡票Entity.set区分(償還情報.get保険給付支払一時差止区分コード());
            共同処理用受給者異動連絡票Entity.set一時差止金額(償還情報.get保険給付支払一時差止金額());
        }
        if (高額情報 != null) {
            共同処理用受給者異動連絡票Entity.set高額送付情報_異動年月日(高額情報.get異動年月日());
            共同処理用受給者異動連絡票Entity.set世帯主被保険者番号(高額情報.get世帯集約番号());
            共同処理用受給者異動連絡票Entity.set世帯所得区分(高額情報.get世帯所得区分コード());
            共同処理用受給者異動連絡票Entity.set所得区分(高額情報.get所得区分コード());
            共同処理用受給者異動連絡票Entity.set利用者負担第２段階(高額情報.is利用者負担第２段階有フラグ());
            共同処理用受給者異動連絡票Entity.set老齢福祉年金受給の有無(高額情報.is老齢福祉年金受給有フラグ());
            共同処理用受給者異動連絡票Entity.set支給申請書出力の有無(高額情報.is支給申請書出力有フラグ());
        }

        return 共同処理用受給者異動連絡票Entity;
    }
}

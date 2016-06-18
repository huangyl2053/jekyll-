/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodoshorijukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKogakuSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共同処理用受給者異動連絡票登録（画面）を管理するクラスです。
 *
 * @reamsid_L DBC-1950-030 chenaoqi
 */
public class KyodoshoriyoJukyushaIdoRenrakuhyoToroku {

    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac dbT3002Dac;
    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dbT3003Dac;
    private final DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac dbT3004Dac;

    /**
     * コンストラクタです。
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoToroku() {
        dbT3002Dac = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
        dbT3003Dac = InstanceProvider.create(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac.class);
        dbT3004Dac = InstanceProvider.create(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaIdoRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return // * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaIdoRenrakuhyoToroku}のインスタンス
     */
    public static KyodoshoriyoJukyushaIdoRenrakuhyoToroku createInstance() {
        return InstanceProvider.create(KyodoshoriyoJukyushaIdoRenrakuhyoToroku.class);
    }

    /**
     * 共同処理用受給者異動連絡票データを作成する
     *
     * @param divEntity 共同処理用受給者異動連絡票共有子DivEntity
     * @return 共同処理用受給者異動連絡票Entity
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity editKyodoshoriyoJukyushaIdoRenrakuhyo(
            KyodoshoriyoJukyushaIdoRenrakuhyoEntity divEntity) {
        if (divEntity == null) {
            return null;
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity 共同処理用受給者異動連絡票Entity = new KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity();
        共同処理用受給者異動連絡票Entity.set作成年月日(FlexibleDate.getNowDate());
        if (divEntity.get共通項目Entity() != null) {

            共同処理用受給者異動連絡票Entity.set証記載保険者番号(divEntity.get共通項目Entity().get証記載保険者番号());
            共同処理用受給者異動連絡票Entity.set被保険者番号(divEntity.get共通項目Entity().get被保険者番号());
            共同処理用受給者異動連絡票Entity.set異動区分(divEntity.get共通項目Entity().get異動区分());
            共同処理用受給者異動連絡票Entity.set異動事由(divEntity.get共通項目Entity().get異動事由());
        }
        if (divEntity.get基本情報Entity() != null) {

            共同処理用受給者異動連絡票Entity.set基本送付情報_異動年月日(divEntity.get基本情報Entity().getIdoYMD());
            共同処理用受給者異動連絡票Entity.set氏名(divEntity.get基本情報Entity().getHiHokenshaName());
            共同処理用受給者異動連絡票Entity.set電話番号(divEntity.get基本情報Entity().getTelNo());
            共同処理用受給者異動連絡票Entity.set郵便番号(divEntity.get基本情報Entity().getYubinNo());
            共同処理用受給者異動連絡票Entity.set住所(divEntity.get基本情報Entity().getAddress());
            共同処理用受給者異動連絡票Entity.set住所カナ(divEntity.get基本情報Entity().getDdressKana());
            共同処理用受給者異動連絡票Entity.set帳票出力順序コード(divEntity.get基本情報Entity().getChohyoOutputJunjyoCode());
        }
        if (divEntity.get償還情報Entity() != null) {
            共同処理用受給者異動連絡票Entity.set償還送付情報_異動年月日(divEntity.get償還情報Entity().getIdoYMD());
            共同処理用受給者異動連絡票Entity.set開始年月日(divEntity.get償還情報Entity().getHokenKyufuIchijiSashitomeKaishiYMD());
            共同処理用受給者異動連絡票Entity.set終了年月日(divEntity.get償還情報Entity().getHokenKyufuIchijiSashitomeShuryoYMD());
            共同処理用受給者異動連絡票Entity.set区分(divEntity.get償還情報Entity().getHokenkyufuIchijiSashitomeKubunCode());
            共同処理用受給者異動連絡票Entity.set一時差止金額(divEntity.get償還情報Entity().getHokenkyufuIchijiSashitomeKingaku());
        }
        if (divEntity.get高額情報Entity() != null) {
            共同処理用受給者異動連絡票Entity.set高額送付情報_異動年月日(divEntity.get高額情報Entity().getIdoYMD());
            共同処理用受給者異動連絡票Entity.set世帯主被保険者番号(divEntity.get高額情報Entity().getSetaiShuyakuNo());
            共同処理用受給者異動連絡票Entity.set世帯所得区分(divEntity.get高額情報Entity().getSetaiShotokuKubunCode());
            共同処理用受給者異動連絡票Entity.set所得区分(divEntity.get高額情報Entity().getShotokuKubunCode());
            共同処理用受給者異動連絡票Entity.set利用者負担第２段階(divEntity.get高額情報Entity().getRiyoshaFutan2DankaiAriFlag());
            共同処理用受給者異動連絡票Entity.set老齢福祉年金受給の有無(divEntity.get高額情報Entity().getRoureiFukushiNenkinJukyuAriFlag());
            共同処理用受給者異動連絡票Entity.set支給申請書出力の有無(divEntity.get高額情報Entity().getShikyuShinseishoOutputAriFlag());
        }

        return 共同処理用受給者異動連絡票Entity;
    }

    /**
     * 異動情報の登録のンメソッドます。
     *
     * @param 異動基本送付Entity KyodoShoriyoJukyushaIdoKihonSofu
     * @param 異動償還送付Entity KyodoShoriyoJukyushaIdoShokanSofu
     * @param 異動高額送付 KyodoShoriyoJukyushaIdoKogakuSofu
     * @throws SystemException 保存処理に失敗した場合
     * @throws ApplicationException 保存処理に失敗した場合
     */
    @Transaction
    public void save異動情報(KyodoShoriyoJukyushaIdoKihonSofu 異動基本送付Entity,
            KyodoShoriyoJukyushaIdoShokanSofu 異動償還送付Entity,
            KyodoShoriyoJukyushaIdoKogakuSofu 異動高額送付) throws SystemException, ApplicationException {
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity dbT3002Entity = 異動基本送付Entity.toEntity();
        dbT3002Entity.setState(EntityDataState.Added);
        dbT3002Dac.save(dbT3002Entity);
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity dbT300Entity = 異動償還送付Entity.toEntity();
        dbT300Entity.setState(EntityDataState.Added);
        dbT3003Dac.save(dbT300Entity);
        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity dbT3004Entity = 異動高額送付.toEntity();
        dbT3004Entity.setState(EntityDataState.Added);
        dbT3004Dac.save(dbT3004Entity);
    }
}

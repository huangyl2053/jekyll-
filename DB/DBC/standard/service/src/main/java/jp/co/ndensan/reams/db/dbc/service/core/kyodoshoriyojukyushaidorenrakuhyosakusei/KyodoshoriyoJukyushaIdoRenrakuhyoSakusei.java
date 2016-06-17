/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票作成（画面）
 *
 * @reamsid_L DBC-1952-020 chenaoqi
 */
public class KyodoshoriyoJukyushaIdoRenrakuhyoSakusei {

    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac 異動基本送付Dac;
    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac 異動償還送付Dac;
    private final DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac 異動高額送付Dac;

    /**
     * コンストラクタです。
     */
    KyodoshoriyoJukyushaIdoRenrakuhyoSakusei() {
        異動基本送付Dac = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
        異動償還送付Dac = InstanceProvider.create(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac.class);
        異動高額送付Dac = InstanceProvider.create(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 異動基本送付Dac DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac
     * @param 異動償還送付Dac DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac
     * @param 異動高額送付Dac DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac
     */
    KyodoshoriyoJukyushaIdoRenrakuhyoSakusei(
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac 異動基本送付Dac,
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac 異動償還送付Dac,
            DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac 異動高額送付Dac) {
        this.異動基本送付Dac = 異動基本送付Dac;
        this.異動償還送付Dac = 異動償還送付Dac;
        this.異動高額送付Dac = 異動高額送付Dac;
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
            KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {
        if (divEntity == null) {
            return null;
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity 共同処理用受給者異動連絡票Entity = new KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity();
        共同処理用受給者異動連絡票Entity.set作成年月日(divEntity.get日付());
        共同処理用受給者異動連絡票Entity.set証記載保険者番号(divEntity.get証記載保険者番号());
        共同処理用受給者異動連絡票Entity.set被保険者番号(divEntity.get被保険者番号());
        共同処理用受給者異動連絡票Entity.set異動区分(divEntity.get異動区分コード());
        共同処理用受給者異動連絡票Entity.set異動事由(divEntity.get異動事由コード());
        共同処理用受給者異動連絡票Entity.set基本送付情報_異動年月日(divEntity.get基本送付情報エリアの異動年月日());
        共同処理用受給者異動連絡票Entity.set氏名(divEntity.get被保険者氏名());
        共同処理用受給者異動連絡票Entity.set電話番号(divEntity.get電話番号());
        共同処理用受給者異動連絡票Entity.set郵便番号(divEntity.get郵便番号());
        共同処理用受給者異動連絡票Entity.set住所(divEntity.get住所());
        共同処理用受給者異動連絡票Entity.set住所カナ(divEntity.get住所カナ());
        共同処理用受給者異動連絡票Entity.set帳票出力順序コード(divEntity.get帳票出力順序コード());
        共同処理用受給者異動連絡票Entity.set訂正区分(divEntity.get訂正区分());
        共同処理用受給者異動連絡票Entity.set訂正年月日(divEntity.get訂正年月日());
        共同処理用受給者異動連絡票Entity.set償還送付情報_異動年月日(divEntity.get償還送付情報エリアの異動年月日());
        共同処理用受給者異動連絡票Entity.set開始年月日(divEntity.get一時差止開始年月日());
        共同処理用受給者異動連絡票Entity.set終了年月日(divEntity.get一時差止終了年月日());
        共同処理用受給者異動連絡票Entity.set区分(divEntity.get一時差止区分());
        共同処理用受給者異動連絡票Entity.set一時差止金額(divEntity.get一時差止金額());
        共同処理用受給者異動連絡票Entity.set高額送付情報_異動年月日(divEntity.get高額送付情報エリアの異動年月日());
        共同処理用受給者異動連絡票Entity.set世帯主被保険者番号(divEntity.get世帯集約番号());
        共同処理用受給者異動連絡票Entity.set世帯所得区分(divEntity.get世帯所得区分());
        共同処理用受給者異動連絡票Entity.set所得区分(divEntity.get所得区分());
        共同処理用受給者異動連絡票Entity.set利用者負担第２段階(divEntity.is利用者負担第２段階());
        共同処理用受給者異動連絡票Entity.set老齢福祉年金受給の有無(divEntity.is老齢福祉年金());
        共同処理用受給者異動連絡票Entity.set支給申請書出力の有無(divEntity.is支給申請書出力());

        return 共同処理用受給者異動連絡票Entity;
    }

    /**
     * 共同処理用受給者訂正連絡票データ作成
     *
     * @param divEntity 共同処理用受給者異動連絡票作成Entity
     * @return 出力用共同処理用受給者訂正情報Entity
     */
    public KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity editKyodoshoriyoJukyushaTeiseiRenrakuhyo(
            KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {

        if (divEntity == null) {
            return null;
        }
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理用受給者訂正情報Entity = new KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity();
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更前訂正情報Entity = get変更前訂正情報(divEntity);
        if (変更前訂正情報Entity == null) {
            return null;
        }
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更後訂正情報Entity = get変更後訂正情報(divEntity);

        if (変更後訂正情報Entity != null) {
            出力用共同処理用受給者訂正情報Entity.set作成年月日(変更後訂正情報Entity.get作成年月日());
            出力用共同処理用受給者訂正情報Entity.set証記載保険者番号(変更後訂正情報Entity.get証記載保険者番号());
            出力用共同処理用受給者訂正情報Entity.set被保険者番号(変更後訂正情報Entity.get被保険者番号());
            出力用共同処理用受給者訂正情報Entity.set異動区分(変更後訂正情報Entity.get異動区分());
            出力用共同処理用受給者訂正情報Entity.set異動事由(変更後訂正情報Entity.get異動事由());
            出力用共同処理用受給者訂正情報Entity.set基本送付情報_異動年月日(変更後訂正情報Entity.get基本送付情報_異動年月日());
            出力用共同処理用受給者訂正情報Entity.set償還送付情報_異動年月日(変更後訂正情報Entity.get償還送付情報_異動年月日());
            出力用共同処理用受給者訂正情報Entity.set高額送付情報_異動年月日(変更後訂正情報Entity.get高額送付情報_異動年月日());
            出力用共同処理用受給者訂正情報Entity.set訂正区分(変更後訂正情報Entity.get訂正区分());
            出力用共同処理用受給者訂正情報Entity.set訂正年月日(変更後訂正情報Entity.get訂正年月日());
            出力用共同処理用受給者訂正情報Entity = get変化有り訂正情報Entity(変更前訂正情報Entity,
                    変更後訂正情報Entity,
                    出力用共同処理用受給者訂正情報Entity);
        }

        return 出力用共同処理用受給者訂正情報Entity;
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get変化有り訂正情報Entity(
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更前訂正情報Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更後訂正情報Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理用受給者訂正情報Entity) {
        if (変更前訂正情報Entity != null) {
            if (変更後訂正情報Entity.get氏名() != null
                    && !変更後訂正情報Entity.get氏名().equals(変更前訂正情報Entity.get氏名())) {
                出力用共同処理用受給者訂正情報Entity.set氏名(変更後訂正情報Entity.get氏名());
            } else {
                出力用共同処理用受給者訂正情報Entity.set氏名(RString.EMPTY);
            }
            if (変更後訂正情報Entity.get証記載保険者番号() != null
                    && !変更後訂正情報Entity.get証記載保険者番号().equals(変更前訂正情報Entity.get証記載保険者番号())) {
                出力用共同処理用受給者訂正情報Entity.set証記載保険者番号(変更後訂正情報Entity.get証記載保険者番号());
            } else {
                出力用共同処理用受給者訂正情報Entity.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
            }
            if (変更後訂正情報Entity.get電話番号() != null
                    && !変更後訂正情報Entity.get電話番号().equals(変更前訂正情報Entity.get電話番号())) {
                出力用共同処理用受給者訂正情報Entity.set電話番号(変更後訂正情報Entity.get電話番号());
            } else {
                出力用共同処理用受給者訂正情報Entity.set電話番号(TelNo.EMPTY);
            }
            if (変更後訂正情報Entity.get郵便番号() != null
                    && !変更後訂正情報Entity.get郵便番号().equals(変更前訂正情報Entity.get郵便番号())) {
                出力用共同処理用受給者訂正情報Entity.set郵便番号(変更後訂正情報Entity.get郵便番号());
            } else {
                出力用共同処理用受給者訂正情報Entity.set郵便番号(YubinNo.EMPTY);
            }
            if (変更後訂正情報Entity.get住所() != null
                    && !変更後訂正情報Entity.get住所().equals(変更前訂正情報Entity.get住所())) {
                出力用共同処理用受給者訂正情報Entity.set住所(変更後訂正情報Entity.get住所());
            } else {
                出力用共同処理用受給者訂正情報Entity.set住所(RString.EMPTY);
            }
            if (変更後訂正情報Entity.get住所カナ() != null
                    && !変更後訂正情報Entity.get住所カナ().equals(変更前訂正情報Entity.get住所カナ())) {
                出力用共同処理用受給者訂正情報Entity.set住所カナ(変更後訂正情報Entity.get住所カナ());
            } else {
                出力用共同処理用受給者訂正情報Entity.set住所カナ(RString.EMPTY);
            }
            if (変更後訂正情報Entity.get帳票出力順序コード() != null
                    && !変更後訂正情報Entity.get帳票出力順序コード().equals(変更前訂正情報Entity.get帳票出力順序コード())) {
                出力用共同処理用受給者訂正情報Entity.set帳票出力順序コード(変更後訂正情報Entity.get帳票出力順序コード());
            } else {
                出力用共同処理用受給者訂正情報Entity.set帳票出力順序コード(RString.EMPTY);
            }
            出力用共同処理用受給者訂正情報Entity = get区分情報Entity(変更前訂正情報Entity,
                    変更後訂正情報Entity,
                    出力用共同処理用受給者訂正情報Entity);
        }

        return 出力用共同処理用受給者訂正情報Entity;

    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get区分情報Entity(KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更前訂正情報Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更後訂正情報Entity,
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 出力用共同処理用受給者訂正情報Entity) {
        if (変更後訂正情報Entity.get開始年月日() != null
                && !変更後訂正情報Entity.get開始年月日().equals(変更前訂正情報Entity.get開始年月日())) {
            出力用共同処理用受給者訂正情報Entity.set開始年月日(変更後訂正情報Entity.get開始年月日());
        } else {
            出力用共同処理用受給者訂正情報Entity.set開始年月日(FlexibleDate.EMPTY);
        }
        if (変更後訂正情報Entity.get終了年月日() != null
                && !変更後訂正情報Entity.get終了年月日().equals(変更前訂正情報Entity.get終了年月日())) {
            出力用共同処理用受給者訂正情報Entity.set終了年月日(変更後訂正情報Entity.get終了年月日());
        } else {
            出力用共同処理用受給者訂正情報Entity.set終了年月日(FlexibleDate.EMPTY);
        }
        if (変更後訂正情報Entity.get区分() != null
                && !変更後訂正情報Entity.get区分().equals(変更前訂正情報Entity.get区分())) {
            出力用共同処理用受給者訂正情報Entity.set区分(変更後訂正情報Entity.get区分());
        } else {
            出力用共同処理用受給者訂正情報Entity.set区分(RString.EMPTY);
        }
        if (変更後訂正情報Entity.get一時差止金額() != null
                && !変更後訂正情報Entity.get一時差止金額().equals(変更前訂正情報Entity.get一時差止金額())) {
            出力用共同処理用受給者訂正情報Entity.set一時差止金額(変更後訂正情報Entity.get一時差止金額());
        } else {
            出力用共同処理用受給者訂正情報Entity.set一時差止金額(null);
        }
        if (変更後訂正情報Entity.get世帯主被保険者番号() != null
                && !変更後訂正情報Entity.get世帯主被保険者番号().equals(変更前訂正情報Entity.get世帯主被保険者番号())) {
            出力用共同処理用受給者訂正情報Entity.set世帯主被保険者番号(変更後訂正情報Entity.get世帯主被保険者番号());
        } else {
            出力用共同処理用受給者訂正情報Entity.set世帯主被保険者番号(HihokenshaNo.EMPTY);
        }
        if (変更後訂正情報Entity.get世帯所得区分() != null
                && !変更後訂正情報Entity.get世帯所得区分().equals(変更前訂正情報Entity.get世帯所得区分())) {
            出力用共同処理用受給者訂正情報Entity.set世帯所得区分(変更後訂正情報Entity.get世帯所得区分());
        } else {
            出力用共同処理用受給者訂正情報Entity.set世帯所得区分(RString.EMPTY);
        }
        if (変更後訂正情報Entity.get所得区分() != null
                && !変更後訂正情報Entity.get所得区分().equals(変更前訂正情報Entity.get所得区分())) {
            出力用共同処理用受給者訂正情報Entity.set所得区分(変更後訂正情報Entity.get所得区分());
        } else {
            出力用共同処理用受給者訂正情報Entity.set所得区分(RString.EMPTY);
        }
        if (変更後訂正情報Entity.is利用者負担第２段階() != 変更前訂正情報Entity.is利用者負担第２段階()) {
            出力用共同処理用受給者訂正情報Entity.set利用者負担第２段階(変更後訂正情報Entity.is利用者負担第２段階());
        }
        if (変更後訂正情報Entity.is老齢福祉年金受給の有無() != 変更前訂正情報Entity.is老齢福祉年金受給の有無()) {
            出力用共同処理用受給者訂正情報Entity.set老齢福祉年金受給の有無(変更後訂正情報Entity.is老齢福祉年金受給の有無());
        }
        if (変更後訂正情報Entity.is支給申請書出力の有無() != 変更前訂正情報Entity.is支給申請書出力の有無()) {
            出力用共同処理用受給者訂正情報Entity.set支給申請書出力の有無(変更後訂正情報Entity.is支給申請書出力の有無());
        }
        return 出力用共同処理用受給者訂正情報Entity;

    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get変更前訂正情報(KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {

        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更前訂正情報Entity = new KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity();
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本送付訂正情報Entity = get基本送付訂正情報(divEntity);
        if (基本送付訂正情報Entity == null) {
            return null;
        }
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還送付訂正情報Entity = get償還送付訂正情報(divEntity);
        if (償還送付訂正情報Entity == null) {
            return null;
        }
        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額送付訂正情報Entity = get高額送付訂正情報(divEntity);
        if (高額送付訂正情報Entity == null) {
            return null;
        }
        変更前訂正情報Entity.set作成年月日(divEntity.get日付());
        変更前訂正情報Entity.set帳票出力順序コード(divEntity.get帳票出力順序コード());
        if (基本送付訂正情報Entity != null) {
            変更前訂正情報Entity.set証記載保険者番号(基本送付訂正情報Entity.getShoKisaiHokenshaNo());
            変更前訂正情報Entity.set被保険者番号(基本送付訂正情報Entity.getHiHokenshaNo());
            変更前訂正情報Entity.set異動区分(基本送付訂正情報Entity.getIdoKubunCode());
            変更前訂正情報Entity.set異動事由(基本送付訂正情報Entity.getJukyushaIdoJiyu());
            変更前訂正情報Entity.set基本送付情報_異動年月日(基本送付訂正情報Entity.getIdoYMD());
            変更前訂正情報Entity.set氏名(基本送付訂正情報Entity.getHiHokenshaName());
            変更前訂正情報Entity.set電話番号(基本送付訂正情報Entity.getTelNo());
            変更前訂正情報Entity.set郵便番号(基本送付訂正情報Entity.getYubinNo());
            変更前訂正情報Entity.set住所(基本送付訂正情報Entity.getAddress());
            変更前訂正情報Entity.set住所カナ(基本送付訂正情報Entity.getDdressKana());
            変更前訂正情報Entity.set訂正区分(基本送付訂正情報Entity.getTeiseiKubunCode());
            変更前訂正情報Entity.set訂正年月日(基本送付訂正情報Entity.getTeiseiYMD());
        }
        if (償還送付訂正情報Entity != null) {
            変更前訂正情報Entity.set償還送付情報_異動年月日(償還送付訂正情報Entity.getIdoYMD());
            変更前訂正情報Entity.set開始年月日(償還送付訂正情報Entity.getHokenKyufuIchijiSashitomeKaishiYMD());
            変更前訂正情報Entity.set終了年月日(償還送付訂正情報Entity.getHokenKyufuIchijiSashitomeShuryoYMD());
            変更前訂正情報Entity.set区分(償還送付訂正情報Entity.getHokenkyufuIchijiSashitomeKubunCode());
            変更前訂正情報Entity.set一時差止金額(償還送付訂正情報Entity.getHokenkyufuIchijiSashitomeKingaku());
        }
        if (高額送付訂正情報Entity != null) {
            変更前訂正情報Entity.set高額送付情報_異動年月日(高額送付訂正情報Entity.getIdoYMD());
            変更前訂正情報Entity.set世帯主被保険者番号(高額送付訂正情報Entity.getSetaiShuyakuNo());
            変更前訂正情報Entity.set世帯所得区分(高額送付訂正情報Entity.getSetaiShotokuKubunCode());
            変更前訂正情報Entity.set所得区分(高額送付訂正情報Entity.getShotokuKubunCode());
            変更前訂正情報Entity.set利用者負担第２段階(高額送付訂正情報Entity.getRiyoshaFutan2DankaiAriFlag());
            変更前訂正情報Entity.set老齢福祉年金受給の有無(高額送付訂正情報Entity.getRoureiFukushiNenkinJukyuAriFlag());
            変更前訂正情報Entity.set支給申請書出力の有無(高額送付訂正情報Entity.getShikyuShinseishoOutputAriFlag());
        }
        return 変更前訂正情報Entity;
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity get変更後訂正情報(KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {

        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 変更後訂正情報Entity = new KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity();
        変更後訂正情報Entity.set作成年月日(divEntity.get日付());
        変更後訂正情報Entity.set証記載保険者番号(divEntity.get証記載保険者番号());
        変更後訂正情報Entity.set被保険者番号(divEntity.get被保険者番号());
        変更後訂正情報Entity.set異動区分(divEntity.get異動区分コード());
        変更後訂正情報Entity.set異動事由(divEntity.get異動事由コード());
        変更後訂正情報Entity.set基本送付情報_異動年月日(divEntity.get基本送付情報エリアの異動年月日());
        変更後訂正情報Entity.set氏名(divEntity.get被保険者氏名());
        変更後訂正情報Entity.set電話番号(divEntity.get電話番号());
        変更後訂正情報Entity.set郵便番号(divEntity.get郵便番号());
        変更後訂正情報Entity.set住所(divEntity.get住所());
        変更後訂正情報Entity.set住所カナ(divEntity.get住所カナ());
        変更後訂正情報Entity.set帳票出力順序コード(divEntity.get帳票出力順序コード());
        変更後訂正情報Entity.set訂正区分(divEntity.get訂正区分());
        変更後訂正情報Entity.set訂正年月日(divEntity.get訂正年月日());
        変更後訂正情報Entity.set償還送付情報_異動年月日(divEntity.get償還送付情報エリアの異動年月日());
        変更後訂正情報Entity.set開始年月日(divEntity.get一時差止開始年月日());
        変更後訂正情報Entity.set終了年月日(divEntity.get一時差止終了年月日());
        変更後訂正情報Entity.set区分(divEntity.get一時差止区分());
        変更後訂正情報Entity.set一時差止金額(divEntity.get一時差止金額());
        変更後訂正情報Entity.set高額送付情報_異動年月日(divEntity.get高額送付情報エリアの異動年月日());
        変更後訂正情報Entity.set世帯主被保険者番号(divEntity.get世帯集約番号());
        変更後訂正情報Entity.set世帯所得区分(divEntity.get世帯所得区分());
        変更後訂正情報Entity.set所得区分(divEntity.get所得区分());
        変更後訂正情報Entity.set利用者負担第２段階(divEntity.is利用者負担第２段階());
        変更後訂正情報Entity.set老齢福祉年金受給の有無(divEntity.is老齢福祉年金());
        変更後訂正情報Entity.set支給申請書出力の有無(divEntity.is支給申請書出力());
        return 変更後訂正情報Entity;
    }

    private DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity get基本送付訂正情報(KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {
        List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> 基本送付訂正情報List = 異動基本送付Dac.selectByKey(divEntity.get被保険者番号(),
                divEntity.get基本送付情報エリアの異動年月日());
        if (基本送付訂正情報List == null || 基本送付訂正情報List.isEmpty()) {
            return null;
        }
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本送付訂正情報Entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        if (基本送付訂正情報List.size() == 2) {
            基本送付訂正情報Entity = 基本送付訂正情報List.get(1);
        }
        return 基本送付訂正情報Entity;

    }

    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity get償還送付訂正情報(KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {
        List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> 償還送付訂正情報List = 異動償還送付Dac.selectByKey(divEntity.get被保険者番号(),
                divEntity.get基本送付情報エリアの異動年月日());
        if (償還送付訂正情報List == null || 償還送付訂正情報List.isEmpty()) {
            return null;
        }
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還送付訂正情報Entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        if (償還送付訂正情報List.size() == 2) {
            償還送付訂正情報Entity = 償還送付訂正情報List.get(1);
        }
        return 償還送付訂正情報Entity;

    }

    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity get高額送付訂正情報(KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiEntity divEntity) {
        List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> 高額送付訂正情報List = 異動高額送付Dac.selectByKey(divEntity.get被保険者番号(),
                divEntity.get基本送付情報エリアの異動年月日());
        if (高額送付訂正情報List == null || 高額送付訂正情報List.isEmpty()) {
            return null;
        }
        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額送付訂正情報Entity = new DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
        if (高額送付訂正情報List.size() == 2) {
            高額送付訂正情報Entity = 高額送付訂正情報List.get(1);
        }
        return 高額送付訂正情報Entity;
    }

}

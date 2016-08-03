/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyotoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者異動連絡票（追加）登録です。
 *
 * @reamsid_L DBC-2100-030 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoToroku {

    private final DbT3001JukyushaIdoRenrakuhyoDac dac;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString 既存の異動日 = new RString("既存の異動日");

    /**
     * コンストラクタです。
     */
    JukyushaIdoRenrakuhyoToroku() {
        dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     */
    JukyushaIdoRenrakuhyoToroku(DbT3001JukyushaIdoRenrakuhyoDac dbT3001Dac) {
        this.dac = dbT3001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoToroku}のインスタンス
     */
    public static JukyushaIdoRenrakuhyoToroku createInstance() {
        return InstanceProvider.create(JukyushaIdoRenrakuhyoToroku.class);
    }

    /**
     * 世受給者異動情報登録処理取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 異動区分 異動区分
     * @return エラー有無("0"：なし "1"：あり)
     */
    @Transaction
    public RString regJukyushaIdoJoho(RString 被保険者番号, RDate 異動日, RString 異動区分) {
        int count = dac.selectCount(被保険者番号, 異動日);
        if (count != 0) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(既存の異動日.toString()));
        } else {
            DbT3001JukyushaIdoRenrakuhyoEntity entity = dac.select異動区分(被保険者番号, 異動日);
            RString idoKubunCode = entity.getIdoKubunCode();
            if ((ONE.equals(異動区分) && THREE.equals(idoKubunCode))
                    || (TWO.equals(異動区分) && (ONE.equals(idoKubunCode) || TWO.equals(idoKubunCode)))
                    || (THREE.equals(異動区分) && (ONE.equals(idoKubunCode) || TWO.equals(idoKubunCode)))) {
                return ONE;
            } else if ((ONE.equals(異動区分) && !THREE.equals(idoKubunCode))
                    || (TWO.equals(異動区分) && (!ONE.equals(idoKubunCode) && !TWO.equals(idoKubunCode)))
                    || (THREE.equals(異動区分) && (!ONE.equals(idoKubunCode) && !TWO.equals(idoKubunCode)))) {
                return ZERO;
            }
        }
        return null;
    }

    /**
     * 登録した受給者異動情報の取得します。
     *
     * @param 被保番号 被保番号
     * @param 送付年月 送付年月
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    @Transaction
    public JukyushaIdoRenrakuhyoTorokuEntity editJukyushaIdoRenrakuhyo(RString 被保番号, RDate 送付年月) {
        DbT3001JukyushaIdoRenrakuhyoEntity entity = dac.select登録した受給者異動情報の取得(被保番号, 送付年月);
        JukyushaIdoRenrakuhyoTorokuEntity jukyuEntity = new JukyushaIdoRenrakuhyoTorokuEntity();
        //TODO
        jukyuEntity.set作成年月日(new FlexibleDate(RString.EMPTY));
        jukyuEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo().getColumnValue());
        jukyuEntity.set被保険者番号(entity.getHiHokenshaNo().getColumnValue());
        jukyuEntity.set異動年月日(entity.getIdoYMD());
        jukyuEntity.set異動区分(entity.getIdoKubunCode());
        //TODO
        jukyuEntity.set氏名性別生年月日を印字する(RString.EMPTY);
        jukyuEntity.set性別(entity.getSeibetsuCode());
        jukyuEntity.set異動事由(entity.getJukyushaIdoJiyu());
        jukyuEntity.set被保険者氏名カナ(entity.getHiHokenshaNameKana());
        jukyuEntity.set生年月日(entity.getUmareYMD());
        jukyuEntity.set資格取得年月日(entity.getShikakuShutokuYMD());
        jukyuEntity.set資格喪失年月日(entity.getShikakuSoshitsuYMD());
        jukyuEntity.setみなし区分(entity.getMinashiYokaigoJotaiKubunCode());
        jukyuEntity.set要介護状態区分(entity.getYokaigoJotaiKubunCode());
        jukyuEntity.set有効期間開始年月日(entity.getNinteiYukoKikankaishiYMD());
        jukyuEntity.set有効期間終了年月日(new FlexibleDate(entity.getNinteiYukoKikanShuryoYMD()));
        jukyuEntity.set支給限度基準額1(new RString(entity.getHomonTsushoServiceShikyuGendoKijungaku()));
        jukyuEntity.set上限管理適用開始年月日１(entity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD());
        jukyuEntity.set上限管理終了年月日１(new FlexibleDate(entity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD()));
        jukyuEntity.set支給限度基準額２(new RString(entity.getTankiNyushoServiceShikyuGendoKijungaku()));
        jukyuEntity.set上限管理適用開始年月日２(entity.getTankinyushoServiceJogenKanriTekiyoKaishiYMD());
        jukyuEntity.set上限管理終了年月日２(entity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD());
        jukyuEntity.set計画作成区分(entity.getKyotakuServiceSakuseiKubunCode());
        jukyuEntity.set居宅支援事業者番号(entity.getKyotakuKaigoShienJigyoshoNo());
        jukyuEntity.set居宅適用開始年月日(new FlexibleDate(entity.getKyotakuServiceTekiyoKaishiYMD()));
        jukyuEntity.set居宅適用終了年月日(new FlexibleDate(entity.getKyotakuServiceTekiyoShuryoYMD()));
        jukyuEntity.set減免申請中区分(entity.getGemmenShinseichuKubunCode());
        jukyuEntity.set利用者負担区分(entity.getRiyoshaFutanKubunCode());
        jukyuEntity.set利用給付率(new RString(entity.getKyufuritsu().toString()));
        jukyuEntity.set利用適用開始年月日(new FlexibleDate(entity.getTekiyoKaishiYMD()));
        jukyuEntity.set利用適用終了年月日(new FlexibleDate(entity.getTekiyoShuryoYMD()));
        jukyuEntity.set標準負担区分(entity.getHyojunFutanKubunCode());
        return jukyuEntity;
    }
}

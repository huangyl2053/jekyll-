/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.FutanyikkatsuShoninList;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogakunintei.FutanGendogakuNinteiBatchResult;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogakuyikkatsushonin.FutangendogakuyikkatsuShoninEntity;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futanyikkatsulist.FutanyikkatsuShoninListMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatchEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.FutanGendogakuNinteiBatchResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4010GemmenGengakuShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018FutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4035FutanyikkatsuShoninListDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanyikkatsushoninkekkalist.IFutanyikkatsuShoninkekkaListFalseMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanyikkatsushoninkekkalist.IFutanyikkatsuShoninkekkaListMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 一括承認結果一覧のビジネス設計（画面）を管理するクラスです。
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
public class IkkatsuShoninKekkaIchiranService {

    private final MapperProvider mapperProvider;
    private final DbT4035FutanyikkatsuShoninListDac DbT4035dac;
    private final DbT4018FutanGendogakuNinteiDac DbT4018dac;
    private final DbT4010GemmenGengakuShinseiDac DbT4010dac;

    /**
     * コンストラクタです。
     */
    IkkatsuShoninKekkaIchiranService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.DbT4035dac = InstanceProvider.create(DbT4035FutanyikkatsuShoninListDac.class);
        this.DbT4018dac = InstanceProvider.create(DbT4018FutanGendogakuNinteiDac.class);
        this.DbT4010dac = InstanceProvider.create(DbT4010GemmenGengakuShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    IkkatsuShoninKekkaIchiranService(MapperProvider mapperProvider,
            DbT4035FutanyikkatsuShoninListDac DbT4035dac,
            DbT4018FutanGendogakuNinteiDac DbT4018dac,
            DbT4010GemmenGengakuShinseiDac DbT4010dac) {
        this.mapperProvider = mapperProvider;
        this.DbT4035dac = DbT4035dac;
        this.DbT4018dac = DbT4018dac;
        this.DbT4010dac = DbT4010dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkkatsuShoninKekkaIchiranService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IkkatsuShoninKekkaIchiranService}のインスタンス
     */
    public static IkkatsuShoninKekkaIchiranService createInstance() {
        return InstanceProvider.create(IkkatsuShoninKekkaIchiranService.class);
    }

    /**
     * 一括処理日時取得
     *
     * @return List<YMDHMS>
     */
    @Transaction
    public List<YMDHMS> load一括処理日時() {
        YMDHMS システム日時 = YMDHMS.now();
        YMDHMS システム日時の1年前 = システム日時.minusYear(1);
        List<YMDHMS> 一括処理日時情報List = new ArrayList<>();
        FutanyikkatsuShoninListMapperParameter 検索条件 = new FutanyikkatsuShoninListMapperParameter(システム日時, システム日時の1年前);
        IFutanyikkatsuShoninkekkaListMapper mapper = mapperProvider.create(IFutanyikkatsuShoninkekkaListMapper.class);
        List<DbT4035FutanGendogakuNinteiBatchEntity> entityList = mapper.get一括処理日時取得(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (DbT4035FutanGendogakuNinteiBatchEntity entity : entityList) {
                一括処理日時情報List.add(entity.getNinteiBatchExecutedTimestamp());
            }
        }
        return 一括処理日時情報List;
    }

    /**
     * 負担限度額一括認定情報取得
     *
     * @param 一括認定バッチ処理日時 YMDHMS
     * @return List<負担限度額一括認定情報>
     */
    @Transaction
    public FutangendogakuyikkatsuShoninEntity load負担限度額一括認定情報(YMDHMS 一括認定バッチ処理日時) {
        DbT4035FutanGendogakuNinteiBatchEntity dbd4035ENtity = DbT4035dac.select負担限度額一括認定情報(一括認定バッチ処理日時);
        FutangendogakuyikkatsuShoninEntity 負担限度額一括認定情報entity = new FutangendogakuyikkatsuShoninEntity();
        if (dbd4035ENtity != null) {
            負担限度額一括認定情報entity.set作成年度(dbd4035ENtity.getSakuseiNendo());
            負担限度額一括認定情報entity.set承認済みフラグ(dbd4035ENtity.getHadApproved());
            負担限度額一括認定情報entity.set決定日(dbd4035ENtity.getKetteiYmd());
        }
        return 負担限度額一括認定情報entity;
    }

    /**
     * 負担限度額認定バッチ結果情報取得
     *
     * @param 一括認定バッチ処理日時 RString
     * @param 承認済みフラグ Boolean
     * @return List<FutanGendogakuNinteiBatchResult>
     */
    @Transaction
    public List<FutanGendogakuNinteiBatchResult> load一括承認結果取得(YMDHMS 一括認定バッチ処理日時, Boolean 承認済みフラグ) {
        RString 減免減額種類_負担限度額認定 = GemmenGengakuShurui.負担限度額認定.getコード();
        FutanyikkatsuShoninListMapperParameter 検索条件 = new FutanyikkatsuShoninListMapperParameter(一括認定バッチ処理日時, 減免減額種類_負担限度額認定);
        FutanyikkatsuShoninListMapperParameter 検索条件2 = new FutanyikkatsuShoninListMapperParameter(減免減額種類_負担限度額認定);
        List<FutanGendogakuNinteiBatchResult> 負担限度額認定バッチ結果 = new ArrayList<>();
        IFutanyikkatsuShoninkekkaListMapper mapper = mapperProvider.create(IFutanyikkatsuShoninkekkaListMapper.class);
        IFutanyikkatsuShoninkekkaListFalseMapper mapperfalse = mapperProvider.create(IFutanyikkatsuShoninkekkaListFalseMapper.class);
        if (承認済みフラグ) {
            List<FutanGendogakuNinteiBatchResultEntity> EntityList = mapper.get一括承認結果情報を取得_承認済みフラグTRUE(検索条件);
            if (EntityList != null && !EntityList.isEmpty()) {
                for (FutanGendogakuNinteiBatchResultEntity entity : EntityList) {
                    FutanGendogakuNinteiEntity futanentity = new FutanGendogakuNinteiEntity();
                    futanentity.set介護保険負担限度額認定Entity(entity.get負担限度額認定());
                    futanentity.set減免減額申請Entity(entity.get減免減額申請());
                    負担限度額認定バッチ結果.add(new FutanGendogakuNinteiBatchResult(entity));
                }
            }
        } else {
            List<FutanGendogakuNinteiBatchResultEntity> EntityList = mapperfalse.get一括承認結果情報を取得_承認済みフラグFALSE(検索条件2);
            if (EntityList != null && !EntityList.isEmpty()) {
                for (FutanGendogakuNinteiBatchResultEntity entity : EntityList) {
                    負担限度額認定バッチ結果.add(new FutanGendogakuNinteiBatchResult(entity));
                }
            }
        }
        return 負担限度額認定バッチ結果;
    }

    /**
     * 介護保険負担限度額認定情報を取得する。
     *
     * @param shikisaihokenno ShoKisaiHokenshaNo
     * @param hihokenshano HihokenshaNo
     * @param 履歴番号 int
     * @return List<KaigoHokenFutanGendogakuNintei>
     */
    @Transaction
    public DbT4018KaigoHokenFutanGendogakuNinteiEntity get介護保険負担限度額認定情報(ShoKisaiHokenshaNo shikisaihokenno,
            HihokenshaNo hihokenshano, int 履歴番号) {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity dbt4018entity = DbT4018dac.selectByKey(shikisaihokenno, hihokenshano, 履歴番号);
        dbt4018entity.initializeMd5();
        return dbt4018entity;
    }

    /**
     * 減免減額申請情報を取得する。
     *
     * @param shokisaihokenno ShoKisaiHokenshaNo
     * @param hihokenshano HihokenshaNo
     * @param 減免減額種類 RString
     * @param 履歴番号 int
     * @return List<GemmenGengakuShinsei>
     */
    @Transaction
    public DbT4010GemmenGengakuShinseiEntity get減免減額申請情報(ShoKisaiHokenshaNo shokisaihokenno, HihokenshaNo hihokenshano,
            RString 減免減額種類,
            int 履歴番号) {
        DbT4010GemmenGengakuShinseiEntity dbt4010entity = DbT4010dac.selectByKey(shokisaihokenno, hihokenshano, 減免減額種類, 履歴番号);
        dbt4010entity.initializeMd5();
        return dbt4010entity;
    }

    /**
     * 負担限度額一括認定情報を取得する。
     *
     * @param 一括認定バッチ処理日時 YMDHMS
     * @return FutanyikkatsuShoninList
     */
    @Transaction
    public FutanyikkatsuShoninList get負担限度額一括認定情報(YMDHMS 一括認定バッチ処理日時) {
        DbT4035FutanGendogakuNinteiBatchEntity DbT4035entity = DbT4035dac.select負担限度額一括認定情報(一括認定バッチ処理日時);
        DbT4035entity.initializeMd5();
        FutanyikkatsuShoninList futanlist = new FutanyikkatsuShoninList(DbT4035entity);
        return futanlist;
    }

    /**
     * saveDbT4018処理を行う。
     *
     * @param KaigoHoken画面情報 DbT4035FutanGendogakuNinteiBatchEntity
     */
    @Transaction
    public void saveDbT4018dac(DbT4018KaigoHokenFutanGendogakuNinteiEntity KaigoHoken画面情報) {
        DbT4018dac.save(KaigoHoken画面情報);
    }

    /**
     * saveDbT4010処理を行う。
     *
     * @param GemmenGen画面情報 GemmenGengakuShinsei
     */
    @Transaction
    public void saveDbT4010dac(DbT4010GemmenGengakuShinseiEntity GemmenGen画面情報) {
        DbT4010dac.save(GemmenGen画面情報);
    }

    /**
     * saveDbT4035処理を行う。
     *
     * @param futan画面情報 FutanyikkatsuShoninList
     */
    @Transaction
    public void saveDbT4035dac(FutanyikkatsuShoninList futan画面情報) {
        DbT4035dac.save(futan画面情報.toEntity());
    }

    /**
     * 「承認を確定する」ボタンをクリック,介護保険負担限度額認定UPDATE処理を行う。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    public void ＤＢ処理_updata介護保険負担限度額認定(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        for (FutanGendogakuNinteiBatchResult futanresult : 画面更新用情報) {
            if (futanresult.get介護保険負担限度額認定の情報() != null) {
                DbT4018KaigoHokenFutanGendogakuNinteiEntity kaigonintei = get介護保険負担限度額認定情報(
                        futanresult.get介護保険負担限度額認定の情報().get証記載保険者番号(),
                        futanresult.get介護保険負担限度額認定の情報().get被保険者番号(),
                        futanresult.get介護保険負担限度額認定の情報().get履歴番号());
                get介護保険負担限度額(futanresult, kaigonintei);
            }
        }
    }

    /**
     * 「承認を確定する」ボタンをクリック,減免減額申請UPDATE処理を行う。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    public void ＤＢ処理_減免減額申請(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        for (FutanGendogakuNinteiBatchResult futanresult : 画面更新用情報) {
            if (futanresult.get介護保険負担限度額認定の情報() != null) {
                List<GemmenGengakuShinsei> gemmengengakulist = futanresult.get介護保険負担限度額認定の情報().getGemmenGengakuShinseiList();
                if (gemmengengakulist != null && !gemmengengakulist.isEmpty()) {
                    get減免減額リスト(futanresult, gemmengengakulist);
                }
            }
        }
    }

    /**
     * 「修正を保存する」ボタンをクリック,介護保険負担限度額認定UPDATE処理を行う。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    @Transaction
    public void update介護保険負担限度額認定(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        for (FutanGendogakuNinteiBatchResult futanresult : 画面更新用情報) {
            if (futanresult.get介護保険負担限度額認定の情報() != null
                    && futanresult.get介護保険負担限度額認定の情報().getState().equals(EntityDataState.Modified)) {
                DbT4018KaigoHokenFutanGendogakuNinteiEntity kaigonintei = get介護保険負担限度額認定情報(
                        futanresult.get介護保険負担限度額認定の情報().get証記載保険者番号(),
                        futanresult.get介護保険負担限度額認定の情報().get被保険者番号(),
                        futanresult.get介護保険負担限度額認定の情報().get履歴番号());
                get介護保険負担限度額(futanresult, kaigonintei);
            }
        }
    }

    /**
     * 「修正を保存する」ボタンをクリック,減免減額申請UPDATE処理を行う。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    @Transaction
    public void get減免減額申請処理(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        for (FutanGendogakuNinteiBatchResult futanresult : 画面更新用情報) {
            List<GemmenGengakuShinsei> gemmengengakulist = futanresult.get介護保険負担限度額認定の情報().getGemmenGengakuShinseiList();
            if (futanresult.get介護保険負担限度額認定の情報() != null
                    && futanresult.get介護保険負担限度額認定の情報().getState().equals(EntityDataState.Modified)
                    && gemmengengakulist != null && !gemmengengakulist.isEmpty()) {
                get減免減額リスト(futanresult, gemmengengakulist);
            }
        }
    }

    private void get介護保険負担限度額(FutanGendogakuNinteiBatchResult futanresult, DbT4018KaigoHokenFutanGendogakuNinteiEntity kaigonintei) {
        if (futanresult.get介護保険負担限度額認定の情報().get一括認定処理日時()
                .equals(kaigonintei.getNinteiBatchExecutedTimestamp())) {
            kaigonintei.setKyusochishaKubun(futanresult.get介護保険負担限度額認定の情報().get旧措置者区分());
            kaigonintei.setShinseiRiyuKubun(futanresult.get介護保険負担限度額認定の情報().get申請理由区分());
            kaigonintei.setRiyoshaFutanDankai(futanresult.get介護保険負担限度額認定の情報().get利用者負担段階());
            kaigonintei.setKyokaisoGaitoshaKubun(futanresult.get介護保険負担限度額認定の情報().is境界層該当者区分());
            kaigonintei.setGekihenKanwaSochiTaishoshaKubun(futanresult.get介護保険負担限度額認定の情報().is激変緩和措置対象者区分());
            kaigonintei.setKyoshitsuShubetsu(futanresult.get介護保険負担限度額認定の情報().get居室種別());
            kaigonintei.setShokuhiFutanGendogaku(futanresult.get介護保険負担限度額認定の情報().get食費負担限度額());
            kaigonintei.setUnitTypeKoshitsu(futanresult.get介護保険負担限度額認定の情報().getユニット型個室());
            kaigonintei.setUnitTypeJunKoshitsu(futanresult.get介護保険負担限度額認定の情報().getユニット型準個室());
            kaigonintei.setJuraiTypeKoshitsu_Tokuyo(futanresult.get介護保険負担限度額認定の情報().get従来型個室_特養等());
            kaigonintei.setJuraiTypeKoshitsu_Roken_Ryoyo(futanresult.get介護保険負担限度額認定の情報().get従来型個室_老健_療養等());
            kaigonintei.setTashoshitsu(futanresult.get介護保険負担限度額認定の情報().get多床室());
            kaigonintei.setHaigushaUmuFlag(futanresult.get介護保険負担限度額認定の情報().is配偶者の有無());
            kaigonintei.setHaigushaShimei(futanresult.get介護保険負担限度額認定の情報().get配偶者氏名());
            kaigonintei.setHaigushaShimeiKana(futanresult.get介護保険負担限度額認定の情報().get配偶者氏名カナ());
            kaigonintei.setHaigushaSeinenGappiYMD(futanresult.get介護保険負担限度額認定の情報().get配偶者生年月日());
            kaigonintei.setHaigushaJusho(futanresult.get介護保険負担限度額認定の情報().get配偶者住所());
            kaigonintei.setHaigushaRenrakusaki(futanresult.get介護保険負担限度額認定の情報().get配偶者連絡先());
            kaigonintei.setHaigushaJusho2(futanresult.get介護保険負担限度額認定の情報().get配偶者住所２());
            kaigonintei.setHaigushaKazeiKubun(futanresult.get介護保険負担限度額認定の情報().get配偶者課税区分());
            kaigonintei.setHaigushaShikibetsuCd(futanresult.get介護保険負担限度額認定の情報().get配偶者識別コード());
            kaigonintei.setYochokinShinkokuKubun(futanresult.get介護保険負担限度額認定の情報().get預貯金申告区分());
            kaigonintei.setYochokinGaku(futanresult.get介護保険負担限度額認定の情報().get預貯金額());
            kaigonintei.setYukashoukenGaisangaku(futanresult.get介護保険負担限度額認定の情報().get有価証券評価概算額());
            kaigonintei.setSonotaKingaku(futanresult.get介護保険負担限度額認定の情報().getその他金額());
            kaigonintei.setShinseiYMD(futanresult.get介護保険負担限度額認定の情報().get申請年月日());
            kaigonintei.setKetteiYMD(futanresult.get介護保険負担限度額認定の情報().get決定年月日());
            kaigonintei.setTekiyoKaishiYMD(futanresult.get介護保険負担限度額認定の情報().get適用開始年月日());
            kaigonintei.setTekiyoShuryoYMD(futanresult.get介護保険負担限度額認定の情報().get適用終了年月日());
            kaigonintei.setKetteiKubun(futanresult.get介護保険負担限度額認定の情報().get決定区分());
            kaigonintei.setHiShoninRiyu(futanresult.get介護保険負担限度額認定の情報().get非承認理由());
            saveDbT4018dac(kaigonintei);
        }
    }

    private void get減免減額リスト(FutanGendogakuNinteiBatchResult futanresult, List<GemmenGengakuShinsei> gemmengengakulist) {
        for (GemmenGengakuShinsei gemmenshinsei : gemmengengakulist) {
            DbT4010GemmenGengakuShinseiEntity dbt4010gemmengen = get減免減額申請情報(
                    futanresult.get介護保険負担限度額認定の情報().get証記載保険者番号(),
                    futanresult.get介護保険負担限度額認定の情報().get被保険者番号(),
                    gemmenshinsei.get減免減額種類(),
                    futanresult.get介護保険負担限度額認定の情報().get履歴番号());
            if (dbt4010gemmengen != null) {
                dbt4010gemmengen.setShinseiTodokedeDaikoKubun(gemmenshinsei.get申請届出代行区分());
                dbt4010gemmengen.setShinseiTodokedeshaShimei(gemmenshinsei.get申請届出者氏名());
                dbt4010gemmengen.setShinseiTodokedeshaKanaShimei(gemmenshinsei.get申請届出者氏名カナ());
                dbt4010gemmengen.setShinseiTodokedeshaTsuzukigara(gemmenshinsei.get申請届出者続柄());
                dbt4010gemmengen.setShinseiTodokedeDaikoJigyoshaNo(gemmenshinsei.get申請届出代行事業者番号());
                dbt4010gemmengen.setJigyoshaKubun(gemmenshinsei.get事業者区分());
                dbt4010gemmengen.setShinseiTodokedeshaYubinNo(gemmenshinsei.get申請届出者郵便番号());
                dbt4010gemmengen.setShinseiTodokedeshaJusho(gemmenshinsei.get申請届出者住所());
                dbt4010gemmengen.setShinseiTodokedeshaTelNo(gemmenshinsei.get申請届出者電話番号());
                saveDbT4010dac(dbt4010gemmengen);
            } else {
                DbT4010GemmenGengakuShinseiEntity gemmgengakuentity = new DbT4010GemmenGengakuShinseiEntity();
                gemmgengakuentity.setShoKisaiHokenshaNo(gemmenshinsei.get証記載保険者番号());
                gemmgengakuentity.setHihokenshaNo(gemmenshinsei.get被保険者番号());
                gemmgengakuentity.setGemmenGengakuShurui(gemmenshinsei.get減免減額種類());
                gemmgengakuentity.setShinseiRirekiNo(gemmenshinsei.get履歴番号());
                gemmgengakuentity.setShinseiTodokedeDaikoKubun(gemmenshinsei.get申請届出代行区分());
                gemmgengakuentity.setShinseiTodokedeshaKanaShimei(gemmenshinsei.get申請届出者氏名カナ());
                gemmgengakuentity.setShinseiTodokedeshaShimei(gemmenshinsei.get申請届出者氏名());
                gemmgengakuentity.setShinseiTodokedeshaTsuzukigara(gemmenshinsei.get申請届出者続柄());
                gemmgengakuentity.setShinseiTodokedeDaikoJigyoshaNo(gemmenshinsei.get申請届出代行事業者番号());
                gemmgengakuentity.setJigyoshaKubun(gemmenshinsei.get事業者区分());
                gemmgengakuentity.setShinseiTodokedeshaYubinNo(gemmenshinsei.get申請届出者郵便番号());
                gemmgengakuentity.setShinseiTodokedeshaJusho(gemmenshinsei.get申請届出者住所());
                gemmgengakuentity.setShinseiTodokedeshaTelNo(gemmenshinsei.get申請届出者電話番号());
                saveDbT4010dac(gemmgengakuentity);
            }
        }
    }
}

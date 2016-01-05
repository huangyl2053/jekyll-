/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.kyokaisogaitosha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.kyokaisogaitosha.KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.kyokaisogaitosha.IKyokaisoGaitoshaMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1007KyokaisoHokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1013KyokaisoSochiShinseiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者台帳管理するクラスです。
 */
public class KyokaisoGaitoshaManager {

    private static final RString 申請 = new RString("1");
    private static final boolean 論理削除フラグ_FALSE = false;
    private static final boolean 論理削除フラグ_TRUE = true;
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString エラーコード = new RString("00250");
    private static final RString 被保険者 = new RString("被保険者番号");
    private final MapperProvider mapperProvider;
    private final DbT1006KyokaisoGaitoshaDac gaitoshaDac;
    private final DbT1007KyokaisoHokenryoDankaiDac hokenryoDankaiDac;
    private final DbT1013KyokaisoSochiShinseiDac sochiShinseiDac;

    /**
     * コンストラクタです。
     */
    KyokaisoGaitoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.gaitoshaDac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
        this.hokenryoDankaiDac = InstanceProvider.create(DbT1007KyokaisoHokenryoDankaiDac.class);
        this.sochiShinseiDac = InstanceProvider.create(DbT1013KyokaisoSochiShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param gaitoshaDac DbT1006KyokaisoGaitoshaDac
     * @param hokenryoDankaiDac DbT1007KyokaisoHokenryoDankaiDac
     * @param sochiShinseiDac DbT1013KyokaisoSochiShinseiDac
     */
    KyokaisoGaitoshaManager(
            MapperProvider mapperProvider,
            DbT1006KyokaisoGaitoshaDac gaitoshaDac,
            DbT1007KyokaisoHokenryoDankaiDac hokenryoDankaiDac,
            DbT1013KyokaisoSochiShinseiDac sochiShinseiDac) {
        this.mapperProvider = mapperProvider;
        this.gaitoshaDac = gaitoshaDac;
        this.hokenryoDankaiDac = hokenryoDankaiDac;
        this.sochiShinseiDac = sochiShinseiDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KyokaisoGaitoshaManager}のインスタンス
     */
    public static KyokaisoGaitoshaManager createInstance() {
        return InstanceProvider.create(KyokaisoGaitoshaManager.class);
    }

    /**
     * 境界層該当一覧情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KyokaisoGaitoshaJoho> 境界層該当者一覧情報
     */
    @Transaction
    public SearchResult<KyokaisoGaitosha> getKyokaisoGaitoshaJohoList(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        List<KyokaisoGaitosha> 境界層該当者一覧情報リスト = new ArrayList<>();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        List<KyokaisoGaitoshaRelateEntity> 境界層該当者一覧リスト = gaitoshaMapper.select一覧情報(parameter);
        for (KyokaisoGaitoshaRelateEntity entity : 境界層該当者一覧リスト) {
            境界層該当者一覧情報リスト.add(new KyokaisoGaitosha(entity));
        }
        return SearchResult.of(境界層該当者一覧情報リスト, 0, false);
    }

    /**
     * 境界層保険料段階グリッド情報の取得処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @param リンク番号 リンク番号
     * @return SearchResult<KyokaisoHokenryoDankai> 境界層保険料段階情報
     */
    @Transaction
    public SearchResult<KyokaisoHokenryoDankai> getKyokaisoHokenryoDakaiJohoList(
            HihokenshaNo 被保険者番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        List<KyokaisoHokenryoDankai> 境界層保険料段階リスト = new ArrayList<>();
        SearchResult<DbT1007KyokaisoHokenryoDankaiEntity> searchResultEntity
                = hokenryoDankaiDac.select境界層保険料段階リスト(被保険者番号, リンク番号, false);
        for (DbT1007KyokaisoHokenryoDankaiEntity entity : searchResultEntity.records()) {
            境界層保険料段階リスト.add(new KyokaisoHokenryoDankai(entity));
        }
        return SearchResult.of(境界層保険料段階リスト, 0, false);
    }

    /**
     * 境界層該当情報の登録処理します。
     *
     * @param entity 境界層該当者管理Div
     * @param 被保険者番号 被保険者番号
     */
    @Transaction
    public void regKyokaisoGaitoshaJoho(
            KyokaisoGaitoshaEntity entity,
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        DbT1006KyokaisoGaitoshaEntity gaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
        DbT1007KyokaisoHokenryoDankaiEntity hokenryoDankaiEntity = new DbT1007KyokaisoHokenryoDankaiEntity();
        DbT1013KyokaisoSochiShinseiEntity sochiShinseiEntity = new DbT1013KyokaisoSochiShinseiEntity();
        gaitoshaEntity.setRirekiNo(get最新履歴番号(parameter));
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//        gaitoshaEntity.setRirekiNo(get最新リンク番号(parameter));
        save境界層該当者(gaitoshaEntity, entity, 被保険者番号);

        sochiShinseiEntity.setRirekiNo(get最新履歴番号(parameter));
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//        sochiShinseiEntity.setRirekiNo(get最新リンク番号(parameter));
        save境界層措置申請(sochiShinseiEntity, entity, 被保険者番号);

        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
        hokenryoDankaiEntity.setRirekiNo(get最新リンク番号(parameter));
        save境界層保険料段階(hokenryoDankaiEntity, entity, 被保険者番号);

    }

    /**
     * 境界層該当情報の更新処理します。
     *
     * @param entityList 境界層該当者管理Div
     * @param 被保険者番号 被保険者番号
     */
    @Transaction
    public void updKyokaisoGaitoshaJoho(
            List<KyokaisoGaitoshaEntity> entityList,
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));

        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        DbT1006KyokaisoGaitoshaEntity gaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
        DbT1013KyokaisoSochiShinseiEntity sochiShinseiEntity = new DbT1013KyokaisoSochiShinseiEntity();
        Decimal 最新履歴番号 = get最新履歴番号(parameter);
        KyokaisoGaitoshaEntity 境界層該当情報 = entityList.get(0);
        境界層該当者情報の更新(被保険者番号, 境界層該当情報.get履歴番号());
        gaitoshaEntity.setRirekiNo(最新履歴番号);
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//        gaitoshaEntity.setRirekiNo(境界層該当情報.getリンク番号());

        境界層措置申請情報の更新(被保険者番号, 境界層該当情報.get履歴番号());
        sochiShinseiEntity.setRirekiNo(最新履歴番号);
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//        sochiShinseiEntity.setRirekiNo(境界層該当情報.getリンク番号());
        save境界層該当者(gaitoshaEntity, 境界層該当情報, 被保険者番号);
        save境界層措置申請(sochiShinseiEntity, 境界層該当情報, 被保険者番号);

        for (KyokaisoGaitoshaEntity entity : entityList) {
            DbT1007KyokaisoHokenryoDankaiEntity hokenryoDankaiEntity = new DbT1007KyokaisoHokenryoDankaiEntity();
            RString 状態 = entity.get保険料段階_状態();
            if (状態 == null || 状態.isEmpty()) {
                break;
            }
            if (状態_登録.equals(状態)) {
                // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
                //        hokenryoDankaiEntity.setRirekiNo(entity.getリンク番号());
                save境界層保険料段階(hokenryoDankaiEntity, entity, 被保険者番号);
            } else if (状態_修正.equals(状態)) {
                // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
                DbT1007KyokaisoHokenryoDankaiEntity 境界層保険料段階
                        = hokenryoDankaiDac.selectByKey(被保険者番号, entity.getリンク番号(), entity.get修正前保険料段階_適用開始日());
                境界層保険料段階.setTekiyoKaishiYM(entity.get保険料段階_適用開始日());
                境界層保険料段階.setTekiyoShuryoYM(entity.get保険料段階_適用終了日());
                境界層保険料段階.setGengakuGoHokenryoDankai(entity.get保険料段階_保険料段階());
                境界層保険料段階.setState(EntityDataState.Modified);
                hokenryoDankaiDac.save(境界層保険料段階);
            } else {
                // TODO 凌護行　SQLの条件漏れ、 QA回答まち
                境界層保険料段階情報の更新(被保険者番号, entity.getリンク番号());
            }
        }
    }

    /**
     * 境界層該当情報の削除処理します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     */
    @Transaction
    public void delKyokaisoGaitoshaJoho(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        境界層該当者情報の更新(被保険者番号, 履歴番号);
        境界層措置申請情報の更新(被保険者番号, 履歴番号);
        境界層保険料段階情報の更新(被保険者番号, 履歴番号);
    }

    /**
     * 境界層該当一覧情報の適用開始日～適用終了日の期間重複チェック処理します。
     *
     * @param entityList 境界層該当一覧情報
     * @param 適用開始日 適用開始日
     * @param 適用終了日 適用終了日
     * @return RString エラーコード
     */
    @Transaction
    public RString checkKyokaisoKikanJufuku(
            List<KyokaisoGaitoshaEntity> entityList,
            FlexibleDate 適用開始日,
            FlexibleDate 適用終了日) {

        // TODO 凌護行　パーラメタの問題　QA389回答まち、　2016/1/18
        Collections.sort(entityList, new DateComparator());

        int 終了日未設定件数 = 0;
        for (KyokaisoGaitoshaEntity entity : entityList) {
            if (状態_削除.equals(entity.get一覧情報_状態())) {
                break;
            }
            if (entity.get終了日() == null || entity.get終了日().isEmpty()) {
                終了日未設定件数 = 終了日未設定件数 + 1;
                if (終了日未設定件数 >= 2) {
                    return エラーコード;
                }
            }
        }
        for (int i = 0; i < entityList.size() - 1; i++) {
            if (状態_削除.equals(entityList.get(i).get一覧情報_状態())) {
                break;
            }
            if (entityList.get(i).get終了日() == null
                    || entityList.get(i).get終了日().isEmpty()) {
                return エラーコード;
            }
            if (!entityList.get(i).get終了日()
                    .isBefore(entityList.get(i + 1).get開始日())) {
                return エラーコード;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 保険料段階の適用開始日～適用終了日の期間重複チェック処理します。
     *
     * @param entityList 境界層該当一覧情報
     * @param 状態 状態
     * @param 適用開始日 適用開始日
     * @param 適用終了日 適用終了日
     * @return RString エラーコード
     */
    @Transaction
    public RString checkHokenryoDankaiKikanJufuku(
            List<KyokaisoHokenryoDankaiEntity> entityList,
            RString 状態,
            FlexibleDate 適用開始日,
            FlexibleDate 適用終了日) {
// TODO 凌護行　パーラメタの問題　QA389回答まち、　2016/1/18
        Collections.sort(entityList, new KyokaisoHokenryoDateComparator());

        int 終了日未設定件数 = 0;
        for (KyokaisoHokenryoDankaiEntity entity : entityList) {
            if (状態_削除.equals(entity.get保険料段階_状態())) {
                break;
            }
            if (entity.get保険料段階_適用終了日() == null || entity.get保険料段階_適用終了日().isEmpty()) {
                終了日未設定件数 = 終了日未設定件数 + 1;
                if (終了日未設定件数 >= 2) {
                    return エラーコード;
                }
            }
        }
        for (int i = 0; i < entityList.size() - 1; i++) {
            if (状態_削除.equals(entityList.get(i).get保険料段階_状態())) {
                break;
            }
            if (entityList.get(i).get保険料段階_適用終了日() == null
                    || entityList.get(i).get保険料段階_適用終了日().isEmpty()) {
                return エラーコード;
            }
            if (!entityList.get(i).get保険料段階_適用終了日()
                    .isBefore(entityList.get(i + 1).get保険料段階_適用開始日())) {
                return エラーコード;
            }
        }
        return RString.EMPTY;
    }

    private void save境界層該当者(
            DbT1006KyokaisoGaitoshaEntity gaitoshaEntity,
            KyokaisoGaitoshaEntity entity,
            HihokenshaNo 被保険者番号) {
        gaitoshaEntity.setHihokenshaNo(被保険者番号);
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//        gaitoshaEntity.set申請年月日(entity.get申請年月日());
//        gaitoshaEntity.set受付年月日(entity.get申請年月日());
        gaitoshaEntity.setTekiyoKaishiYMD(entity.get開始日());
        gaitoshaEntity.setTekiyoShuryoYMD(entity.get終了日());
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
//      gaitoshaEntity.set措置該当_非該当区分(entity.get措置該当_非該当区分());
        gaitoshaEntity.setKyokaisoSochiKetteiYMD(entity.get決定日());
        gaitoshaEntity.setKyuufugakuGengakuKisaiKiajoFlag(entity.get給付額減額記載解除フラグ());
        gaitoshaEntity.setHyojunFutanGengakuGaitoFlag(entity.get標準負担額額該当フラグ());
        gaitoshaEntity.setHyojunFutanKeigengoFutangaku(entity.get標準負担軽減後負担額());
        gaitoshaEntity.setKyojuhinadoFutangakugengakuGaitoFlag(entity.get居住費等負担額減額該当フラグ());
        gaitoshaEntity.setKyojuhiKeigengoKyoshitsuShuruiCode(entity.get居住費軽減後居室種類コード());
        gaitoshaEntity.setKyojuhiKeigengoHutangaku(entity.get居住費軽減後負担額());
        gaitoshaEntity.setShokuhiKeigengoHutangakuGaitoFlag(entity.get食費負担額減額該当フラグ());
        gaitoshaEntity.setShokuhiKeigengoHutangaku(entity.get食費軽減後負担額());
        gaitoshaEntity.setKogakuServicehiJogengakuGengakuGaitoFlag(entity.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ());
        gaitoshaEntity.setKogakuServicehiJogengakuGengakugoJogengaku(entity.get読替後高額介護世帯上限額());
        gaitoshaEntity.setHokenryoNofuGengakuFlag(entity.get保険料納付減額フラグ());
        gaitoshaEntity.setIsDeleted(論理削除フラグ_FALSE);

        gaitoshaDac.save(gaitoshaEntity);
    }

    private void save境界層措置申請(
            DbT1013KyokaisoSochiShinseiEntity sochiShinseiEntity,
            KyokaisoGaitoshaEntity entity,
            HihokenshaNo 被保険者番号) {
        sochiShinseiEntity.setHihokenshaNo(被保険者番号);
        sochiShinseiEntity.setShinsei_HaishiKubun(申請);
        sochiShinseiEntity.setShinsei_HaishiYMD(entity.get申請_廃止年月日());
        sochiShinseiEntity.setHogoHuyoKonkyoGengakuKingaku(entity.get保護不要根拠減額金額());
        sochiShinseiEntity.setKyokaisoShomeishoKofuYMD(entity.get境界層証明書交付年月日());
        sochiShinseiEntity.setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(entity.get給付額減額取消_減額自己負担月額());
        sochiShinseiEntity.setKyojuhiKeigen_GengakuJikofutanGetsugaku(entity.get居住費軽減_減額自己負担月額());
        sochiShinseiEntity.setKyojuhiKeigen_FutangendogakuDankaiCode(entity.get居住費軽減_負担限度額段階());
        sochiShinseiEntity.setShokuhiKeigen_GengakuJikofutanGetsugaku(entity.get食費軽減_減額自己負担月額());
        sochiShinseiEntity.setShokuhiKeigen_FutangendogakuDankaiCode(entity.get食費軽減_負担限度額段階());
        sochiShinseiEntity.setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(entity.get利用者負担世帯合算額_減額自己負担月額());
        sochiShinseiEntity.setHokenryoGengaku_GengakuJikofutanGetsugaku(entity.get介護保険料減額_減額自己負担月額());
        sochiShinseiEntity.setGengakuJikofutanGetsugakuGokeigaku(entity.get減額自己負担月額合計額());
        // TODO 凌護行　DBに項目が無し、　QA316回答まち、　2016/1/18
        sochiShinseiEntity.setShinseiYMD(new FlexibleDate("20160105"));
        sochiShinseiEntity.setUketsukeYMD(new FlexibleDate("20160106"));
        sochiShinseiEntity.setIsDeleted(論理削除フラグ_FALSE);

        sochiShinseiDac.save(sochiShinseiEntity);
    }

    private void save境界層保険料段階(
            DbT1007KyokaisoHokenryoDankaiEntity hokenryoDankaiEntity,
            KyokaisoGaitoshaEntity entity,
            HihokenshaNo 被保険者番号) {
        hokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
        hokenryoDankaiEntity.setTekiyoKaishiYM(entity.get保険料段階_適用開始日());
        hokenryoDankaiEntity.setTekiyoShuryoYM(entity.get保険料段階_適用終了日());
        hokenryoDankaiEntity.setGengakuGoHokenryoDankai(entity.get保険料段階_保険料段階());
        hokenryoDankaiEntity.setIsDeleted(論理削除フラグ_FALSE);

        hokenryoDankaiDac.save(hokenryoDankaiEntity);
    }

    private void 境界層該当者情報の更新(HihokenshaNo 被保険者番号, Decimal 履歴番号) {
        DbT1006KyokaisoGaitoshaEntity gaitoshaEntity = gaitoshaDac.selectByKey(被保険者番号, 履歴番号);
        gaitoshaEntity.setIsDeleted(論理削除フラグ_TRUE);
        gaitoshaEntity.setState(EntityDataState.Modified);
        gaitoshaDac.save(gaitoshaEntity);
    }

    private void 境界層措置申請情報の更新(HihokenshaNo 被保険者番号, Decimal 履歴番号) {
        DbT1013KyokaisoSochiShinseiEntity sochiShinseiEntity = sochiShinseiDac.selectByKey(被保険者番号, 履歴番号);
        sochiShinseiEntity.setIsDeleted(論理削除フラグ_TRUE);
        sochiShinseiEntity.setState(EntityDataState.Modified);
        sochiShinseiDac.save(sochiShinseiEntity);
    }

    private void 境界層保険料段階情報の更新(HihokenshaNo 被保険者番号, Decimal 履歴番号) {
        // TODO 凌護行　SQLの条件漏れ、 QA回答まち
        DbT1007KyokaisoHokenryoDankaiEntity hokenryoDankaiEntity = hokenryoDankaiDac.selectByKey(被保険者番号, 履歴番号, FlexibleYearMonth.MAX);
        hokenryoDankaiEntity.setIsDeleted(論理削除フラグ_TRUE);
        hokenryoDankaiEntity.setState(EntityDataState.Modified);
        hokenryoDankaiDac.save(hokenryoDankaiEntity);
    }

    private Decimal get最新履歴番号(KyokaisoGaitoshaParameter parameter) {
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        Decimal 最新履歴番号 = gaitoshaMapper.selcet最新履歴番号(parameter);
        if (最新履歴番号 == null) {
            最新履歴番号 = new Decimal(1);
        } else {
            最新履歴番号 = new Decimal(最新履歴番号.intValue() + 1);
        }
        return 最新履歴番号;
    }

    private Decimal get最新リンク番号(KyokaisoGaitoshaParameter parameter) {
        IKyokaisoGaitoshaMapper gaitoshaMapper = mapperProvider.create(IKyokaisoGaitoshaMapper.class);
        Decimal 最新リンク番号 = gaitoshaMapper.selcet最新リンク番号(parameter);
        if (最新リンク番号 == null) {
            最新リンク番号 = new Decimal(1);
        } else {
            最新リンク番号 = new Decimal(最新リンク番号.intValue() + 1);
        }
        return 最新リンク番号;
    }

    private static class DateComparator implements Comparator<KyokaisoGaitoshaEntity>, Serializable {

        private static final long serialVersionUID = -2908295330582757718L;

        @Override
        public int compare(KyokaisoGaitoshaEntity o1, KyokaisoGaitoshaEntity o2) {
            int 境界層該当一覧情報 = o1.get開始日().compareTo(o2.get開始日());
            if (境界層該当一覧情報 == 0) {
                return o1.get終了日().compareTo(o2.get終了日());
            }
            return 境界層該当一覧情報;
        }
    }

    private static class KyokaisoHokenryoDateComparator implements Comparator<KyokaisoHokenryoDankaiEntity>, Serializable {

        private static final long serialVersionUID = -5836270759887778883L;

        @Override
        public int compare(KyokaisoHokenryoDankaiEntity o1, KyokaisoHokenryoDankaiEntity o2) {
            int 境保険料段階情報 = o1.get保険料段階_適用開始日().compareTo(o2.get保険料段階_適用開始日());
            if (境保険料段階情報 == 0) {
                return o1.get保険料段階_適用終了日().compareTo(o2.get保険料段階_適用終了日());
            }
            return 境保険料段階情報;
        }
    }
}

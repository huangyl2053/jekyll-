/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD4010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran.ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujohaaku.IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper;
import jp.co.ndensan.reams.db.dbd.service.core.dbd4100001.ShichosonCodeYoriShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBDMN41001_障がい者控除対象者把握の_process処理クラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranProcess extends BatchProcessBase<ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID_控除対象者出力 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper"
            + ".relate.shogaishakoujohaaku.IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper.get障がい者控除対象者出力一覧情報");
    private ShogaishaKojoTaishoshaHaakuKekkaIchiranProcessParameter parameter;

    private ShichosonSecurityJoho 市町村セキュリティ;
    private LasdecCode 市町村コード;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 認定区分;
    private RString 認定内容;
    private RString code認知症高齢者;
    private RString code障害高齢者;
    private List<DbT4038ShogaishaKoujoEntity> 障がい者控除情報List;
    private List<DbT4038ShogaishaKoujoEntity> 障がい者控除情報ListClone;
    private List<DbT4038ShogaishaKoujoEntity> 被保険者番号障がい者List;
    private List<DbT4038ShogaishaKoujoEntity> deleted障がい者List;
    private List<DbT4038ShogaishaKoujoEntity> noDeleted障がい者List;

    private List<DbT4010GemmenGengakuShinseiEntity> 減免減額申請List;
    private List<DbT4010GemmenGengakuShinseiEntity> 減免減額申請ListClone;

    private int rirekiNo;
    private FlexibleYear taishoNendo;
    private FlexibleYear nextTaishoNendo;

    private DbT4038ShogaishaKoujoEntity dbt4038Entity;
    private DbT4010GemmenGengakuShinseiEntity dbt4010Entity;

    @BatchWriter
    private BatchPermanentTableWriter<DbT4010GemmenGengakuShinseiEntity> tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4038ShogaishaKoujoEntity> dbt4038tableWriter;

    @Override
    protected void initialize() {
        障がい者控除情報ListClone = new ArrayList<>();
        被保険者番号障がい者List = new ArrayList<>();
        deleted障がい者List = new ArrayList<>();
        noDeleted障がい者List = new ArrayList<>();

        減免減額申請ListClone = new ArrayList<>();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_控除対象者出力, parameter.shogaishaKojoTaishoshaHaakuKekkaIchiranMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT4010GemmenGengakuShinseiEntity.class);
        dbt4038tableWriter = new BatchPermanentTableWriter<>(DbT4038ShogaishaKoujoEntity.class);
    }

    @Override
    protected void beforeExecute() {
        市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        障がい者控除情報List = getMapper(IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper.class).get障がい者控除();
        減免減額申請List = getMapper(IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper.class).get減免減額申請();
        減免減額申請ListClone.addAll(減免減額申請List);
        障がい者控除情報ListClone.addAll(障がい者控除情報List);
    }

    @Override
    protected void process(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        if (控除対象者データ.get広住特措置元市町村コード() != null && !控除対象者データ.get広住特措置元市町村コード().isEmpty()) {
            市町村コード = 控除対象者データ.get広住特措置元市町村コード();
        } else {
            市町村コード = 控除対象者データ.get市町村コード();
        }

        if (市町村セキュリティ.get導入形態コード().value().equals(DonyuKeitaiCode.事務単一.getCode())) {
            証記載保険者番号 = 市町村セキュリティ.get市町村情報().get証記載保険者番号();
        } else if (市町村セキュリティ.get導入形態コード().value().equals(DonyuKeitaiCode.事務広域.getCode())
                || 市町村セキュリティ.get導入形態コード().value().equals(DonyuKeitaiCode.事務構成市町村.getCode())) {
            DbT7051KoseiShichosonMasterEntity 市町村Entity = ShichosonCodeYoriShichosonJoho.getShichosonCodeYoriShichosonJoho(市町村コード);
            証記載保険者番号 = 市町村Entity.getShoKisaiHokenshaNo();
        }
        set認定区分と認定内容(控除対象者データ);
        set障がい者控除出力(控除対象者データ);
        up障がい者控除出力(控除対象者データ);
        被保険者番号障がい者List.clear();
        noDeleted障がい者List.clear();
        deleted障がい者List.clear();
        障がい者控除情報List.clear();

        減免減額申請List.clear();

        障がい者控除情報List.addAll(障がい者控除情報ListClone);
        減免減額申請List.addAll(減免減額申請ListClone);
    }

    private void set認定区分と認定内容(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {

        if (控除対象者データ.get認知症高齢者の日常生活自立度コード() == null || 控除対象者データ.get認知症高齢者の日常生活自立度コード().isEmpty()) {
            code認知症高齢者 = RString.EMPTY;
        } else {
            code認知症高齢者 = new RString(控除対象者データ.get認知症高齢者の日常生活自立度コード().toString());
        }
        if (控除対象者データ.get障害高齢者の日常生活自立度コード() == null || 控除対象者データ.get障害高齢者の日常生活自立度コード().isEmpty()) {
            code障害高齢者 = RString.EMPTY;
        } else {
            code障害高齢者 = new RString(控除対象者データ.get障害高齢者の日常生活自立度コード().toString());
        }
        if (認定区分と認定内容の設定A(code認知症高齢者) && 認定区分と認定内容の設定B(code障害高齢者)) {
            認定区分 = Ninteikubun.障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.身体障がい者_３から６級_に準ずる.getコード();
        } else if (認定区分と認定内容の設定A(code認知症高齢者) && 認定区分と認定内容の設定C(code障害高齢者)) {
            認定区分 = Ninteikubun.特別障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.ねたきり老人.getコード();
        } else if (認定区分と認定内容の設定D(code認知症高齢者) && 認定区分と認定内容の設定B(code障害高齢者)) {
            認定区分 = Ninteikubun.障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.知的障がい者_軽度_中度_に準ずる.getコード();
        } else if (認定区分と認定内容の設定D(code認知症高齢者) && 認定区分と認定内容の設定C(code障害高齢者)) {
            認定区分 = Ninteikubun.特別障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.ねたきり老人.getコード();
        } else {
            set認定区分();
        }
    }

    private void set認定区分() {
        if (認定区分と認定内容の設定E(code認知症高齢者) && 認定区分と認定内容の設定B(code障害高齢者)) {
            認定区分 = Ninteikubun.特別障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.知的障がい者_重度_に準ずる.getコード();
        } else if (認定区分と認定内容の設定E(code認知症高齢者) && 認定区分と認定内容の設定C(code障害高齢者)) {
            認定区分 = Ninteikubun.特別障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.知的障がい者_重度_に準ずる.getコード();
        } else if (認定区分と認定内容の設定D(code認知症高齢者) && 認定区分と認定内容の設定G(code障害高齢者)) {
            認定区分 = Ninteikubun.障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.知的障がい者_軽度_中度_に準ずる.getコード();
        } else if (認定区分と認定内容の設定E(code認知症高齢者) && 認定区分と認定内容の設定G(code障害高齢者)) {
            認定区分 = Ninteikubun.障がい者.getコード();
            認定内容 = NinteiNaiyoKubun.知的障がい者_重度_に準ずる.getコード();
        }
    }

    private void up障がい者控除出力(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        for (DbT4038ShogaishaKoujoEntity entity : 障がい者控除情報List) {
            if (entity.getHihokenshaNo().equals(控除対象者データ.get被保険者番号()) && entity.getRirekiNo() == 0) {
                障がい者控除情報ListClone.remove(entity);
                dbt4038tableWriter.delete(entity);

                減免減額申請ListClone.remove(find減免減額申請(entity, false));
                tableWriter.delete(find減免減額申請(entity, false));
            }
        }
    }

    private void set障がい者控除出力(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {

        for (DbT4038ShogaishaKoujoEntity entity : 障がい者控除情報List) {
            if (entity.getHihokenshaNo().equals(控除対象者データ.get被保険者番号())) {
                被保険者番号障がい者List.add(entity);
                set障がい者List(entity);
            }
        }
        if (!deleted障がい者List.isEmpty()) {
            nextTaishoNendo = deleted障がい者List.get(0).getTaishoNendo();
        }
        if (!被保険者番号障がい者List.isEmpty() && 控除対象者データ != null) {
            set履歴番号0の申請データ(控除対象者データ);
            set申請決定を同時に行う(控除対象者データ);
        } else if (控除対象者データ != null) {
            dbt4038Entity = new DbT4038ShogaishaKoujoEntity();
            dbt4038Entity.setRirekiNo(1);
            set障がい者控除(控除対象者データ, dbt4038Entity);
            障がい者控除情報ListClone.add(dbt4038Entity);
            dbt4038tableWriter.insert(dbt4038Entity);

            dbt4010Entity = new DbT4010GemmenGengakuShinseiEntity();
            dbt4010Entity.setShinseiRirekiNo(1);
            set減免減額申請(控除対象者データ);
            減免減額申請ListClone.add(dbt4010Entity);
            tableWriter.insert(dbt4010Entity);

        }
    }

    private void set障がい者List(DbT4038ShogaishaKoujoEntity entity) {
        FlexibleYear nendo = entity.getTaishoNendo();
        if (nendo != null && nendo.isBeforeOrEquals(parameter.get対象年度())) {
            taishoNendo = entity.getTaishoNendo();
            rirekiNo = entity.getRirekiNo();
            noDeleted障がい者List.add(entity);
        } else {
            deleted障がい者List.add(entity);
        }
    }

    private void set申請決定を同時に行う(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        if (!find障がい者控除(parameter.get対象年度(), 控除対象者データ.get被保険者番号(), 証記載保険者番号)) {
            if (nextTaishoNendo == null) {
                set対象の申請データを更新する(控除対象者データ);
            } else {
                set履歴の途中に追加(控除対象者データ);
            }
        } else {
            set更新申請データ(控除対象者データ);
        }

    }

    private void set更新申請データ(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        for (DbT4038ShogaishaKoujoEntity 障がい者控除 : 障がい者控除情報List) {
            FlexibleYear nendo = 障がい者控除.getTaishoNendo();
            if (nendo != null && nendo.equals(taishoNendo) && 障がい者控除.getHihokenshaNo().equals(控除対象者データ.get被保険者番号())
                    && 障がい者控除.getShoKisaiHokenshaNo().equals(証記載保険者番号)) {
                障がい者控除.setKetteiKubun(new RString("1"));
                dbt4038tableWriter.update(障がい者控除);
            }
        }
    }

    private void set対象の申請データを更新する(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        if (taishoNendo != null && taishoNendo.equals(parameter.get対象年度())) {
            for (DbT4038ShogaishaKoujoEntity entity : 障がい者控除情報List) {
                FlexibleYear taishonendo = entity.getTaishoNendo();
                if (taishonendo != null && entity.getHihokenshaNo().equals(控除対象者データ.get被保険者番号()) && taishonendo.equals(taishoNendo)) {
                    entity.setKetteiKubun(new RString("1"));
                    dbt4038tableWriter.update(entity);
                }
            }
        } else {
            dbt4038Entity = new DbT4038ShogaishaKoujoEntity();
            dbt4038Entity.setRirekiNo(rirekiNo + 1);
            set障がい者控除(控除対象者データ, dbt4038Entity);
            障がい者控除情報ListClone.add(dbt4038Entity);
            dbt4038tableWriter.insert(dbt4038Entity);

            dbt4010Entity = new DbT4010GemmenGengakuShinseiEntity();
            dbt4010Entity.setShinseiRirekiNo(rirekiNo + 1);
            set減免減額申請(控除対象者データ);
            if (!isRecordExists(dbt4010Entity)) {
                減免減額申請ListClone.add(dbt4010Entity);
                tableWriter.insert(dbt4010Entity);
            }
        }
    }

    private boolean isRecordExists(DbT4010GemmenGengakuShinseiEntity entity) {
        boolean state = false;
        if (entity != null) {
            for (DbT4010GemmenGengakuShinseiEntity 減免減額Entity : 減免減額申請List) {
                if (減免減額Entity.getHihokenshaNo().equals(entity.getHihokenshaNo())
                        && (減免減額Entity.getShinseiRirekiNo() == entity.getShinseiRirekiNo())
                        && 減免減額Entity.getShoKisaiHokenshaNo().equals(entity.getShoKisaiHokenshaNo())) {
                    state = true;
                }
            }
        }
        return state;
    }

    private void set履歴の途中に追加(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        for (DbT4038ShogaishaKoujoEntity entity : 障がい者控除情報List) {
            FlexibleYear getTaishonendo = entity.getTaishoNendo();
            if (getTaishonendo != null && entity.getHihokenshaNo().equals(控除対象者データ.get被保険者番号()) && !getTaishonendo.isBefore(taishoNendo)) {
                障がい者控除情報ListClone.remove(entity);
                dbt4038tableWriter.delete(entity);

                if (isRecordExists(find減免減額申請(entity, false))) {
                    減免減額申請ListClone.remove(find減免減額申請(entity, false));
                    tableWriter.delete(find減免減額申請(entity, false));
                }
            }
        }

        dbt4038Entity = new DbT4038ShogaishaKoujoEntity();
        dbt4038Entity.setRirekiNo(rirekiNo + 1);
        set障がい者控除(控除対象者データ, dbt4038Entity);
        障がい者控除情報ListClone.add(dbt4038Entity);
        dbt4038tableWriter.insert(dbt4038Entity);

        dbt4010Entity = new DbT4010GemmenGengakuShinseiEntity();
        dbt4010Entity.setShinseiRirekiNo(rirekiNo + 1);
        set減免減額申請(控除対象者データ);
        減免減額申請ListClone.add(dbt4010Entity);
        tableWriter.insert(dbt4010Entity);

        for (DbT4038ShogaishaKoujoEntity entity : deleted障がい者List) {
            entity.setRirekiNo(entity.getRirekiNo() + 1);
            障がい者控除情報ListClone.add(entity);
            dbt4038tableWriter.insert(entity);

            DbT4010GemmenGengakuShinseiEntity dbt4010 = find減免減額申請(entity, true);
            if (dbt4010 != null) {
                減免減額申請ListClone.add(dbt4010);
                tableWriter.insert(dbt4010);
            }
        }
    }

    private void set履歴番号0の申請データ(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        if (noDeleted障がい者List.size() == 1 && deleted障がい者List.isEmpty() && taishoNendo.equals(parameter.get対象年度())) {
            DbT4038ShogaishaKoujoEntity newEntity = 被保険者番号障がい者List.get(0).clone();
            newEntity.setRirekiNo(1);
            set障がい者控除(控除対象者データ, newEntity);
            障がい者控除情報ListClone.remove(被保険者番号障がい者List.get(0));
            dbt4038tableWriter.delete(被保険者番号障がい者List.get(0));
            被保険者番号障がい者List.remove(0);
            被保険者番号障がい者List.add(newEntity);
            障がい者控除情報ListClone.add(newEntity);
            dbt4038tableWriter.insert(newEntity);

            減免減額申請ListClone.remove(find減免減額申請(被保険者番号障がい者List.get(0), false));
            tableWriter.delete(find減免減額申請(被保険者番号障がい者List.get(0), false));

            dbt4010Entity = new DbT4010GemmenGengakuShinseiEntity();
            dbt4010Entity.setShinseiRirekiNo(1);
            set減免減額申請(控除対象者データ);
            減免減額申請ListClone.add(dbt4010Entity);
            tableWriter.insert(dbt4010Entity);
        }
    }

    private DbT4010GemmenGengakuShinseiEntity find減免減額申請(DbT4038ShogaishaKoujoEntity entity, boolean state) {
        for (DbT4010GemmenGengakuShinseiEntity 減免減額Entity : 減免減額申請List) {
            if (減免減額Entity.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && (減免減額Entity.getShinseiRirekiNo() == entity.getRirekiNo())
                    && 減免減額Entity.getShoKisaiHokenshaNo().equals(entity.getShoKisaiHokenshaNo())) {
                if (state) {
                    減免減額Entity.setShinseiRirekiNo(entity.getRirekiNo() + 1);
                }
                return 減免減額Entity;
            }
        }
        return null;
    }

    private boolean find障がい者控除(FlexibleYear taishoNendo, HihokenshaNo hihokenshaNo, ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        for (DbT4038ShogaishaKoujoEntity 障がい者控除 : 障がい者控除情報List) {
            FlexibleYear nendo = 障がい者控除.getTaishoNendo();
            if (nendo != null && nendo.equals(taishoNendo) && 障がい者控除.getHihokenshaNo().equals(hihokenshaNo)
                    && 障がい者控除.getShoKisaiHokenshaNo().equals(shoKisaiHokenshaNo)) {
                return true;
            }
        }
        return false;
    }

    private DbT4038ShogaishaKoujoEntity set障がい者控除(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ, DbT4038ShogaishaKoujoEntity newEntity) {
        if (控除対象者データ.get被保険者番号() == null || 控除対象者データ.get被保険者番号().isEmpty()) {
            newEntity.setHihokenshaNo(HihokenshaNo.EMPTY);
        } else {
            newEntity.setHihokenshaNo(控除対象者データ.get被保険者番号());
        }
        newEntity.setShoKisaiHokenshaNo(証記載保険者番号);
        if (控除対象者データ.get申請理由() == null || 控除対象者データ.get申請理由().isEmpty()) {
            newEntity.setShinseiJiyu(RString.EMPTY);
        } else {
            newEntity.setShinseiJiyu(控除対象者データ.get申請理由());
        }

        newEntity.setTaishoNendo(parameter.get対象年度());
        newEntity.setKijunYMD(parameter.get基準日());
        newEntity.setHaakuYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
        newEntity.setNinteiKubun(認定区分);
        newEntity.setNinteiNaiyo(認定内容);
        if (控除対象者データ.get認知症高齢者の日常生活自立度コード() == null || 控除対象者データ.get認知症高齢者の日常生活自立度コード().isEmpty()) {
            newEntity.setNinchishoNichijoSeikatsuJiritsudoCode(Code.EMPTY);
        } else {
            newEntity.setNinchishoNichijoSeikatsuJiritsudoCode(控除対象者データ.get認知症高齢者の日常生活自立度コード());
        }

        if (控除対象者データ.get障害高齢者の日常生活自立度コード() == null || 控除対象者データ.get障害高齢者の日常生活自立度コード().isEmpty()) {
            newEntity.setShogaiNichijoSeikatsuJiritsudoCode(Code.EMPTY);
        } else {
            newEntity.setShogaiNichijoSeikatsuJiritsudoCode(new Code(控除対象者データ.get障害高齢者の日常生活自立度コード().toString()));
        }

        newEntity.setShogaishaTechoUmu(false);

        if (控除対象者データ.get資格喪失事由コード() == null || 控除対象者データ.get資格喪失事由コード().isEmpty()) {
            newEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        } else {
            newEntity.setShikakuSoshitsuJiyuCode(控除対象者データ.get資格喪失事由コード());
        }

        if (控除対象者データ.get資格喪失年月日() == null || 控除対象者データ.get資格喪失年月日().isEmpty()) {
            newEntity.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
        } else {
            newEntity.setShikakuSoshitsuYMD(控除対象者データ.get資格喪失年月日());
        }

        newEntity.setNinteishoHakkoTaishogai(false);
        newEntity.setShinseiYMD(parameter.get申請年月日());
        newEntity.setKetteiYMD(parameter.get決定年月日());
        newEntity.setTekiyoKaishiYMD(FlexibleDate.EMPTY);
        newEntity.setTekiyoShuryoYMD(FlexibleDate.EMPTY);
        newEntity.setKetteiKubun(new RString("1"));
        newEntity.setHiShoninRiyu(RString.EMPTY);
        return newEntity;
    }

    private DbT4010GemmenGengakuShinseiEntity set減免減額申請(ShogaishaKojoTaishoshaHaakuKekkaIchiranEntity 控除対象者データ) {
        if (控除対象者データ.get被保険者番号() == null || 控除対象者データ.get被保険者番号().isEmpty()) {
            dbt4010Entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        } else {
            dbt4010Entity.setHihokenshaNo(控除対象者データ.get被保険者番号());
        }

        dbt4010Entity.setShoKisaiHokenshaNo(証記載保険者番号);
        dbt4010Entity.setGemmenGengakuShurui(GemmenGengakuShurui.障がい者控除.getコード());
        return dbt4010Entity;
    }

    private boolean 認定区分と認定内容の設定A(RString code) {
        return (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード()))
                || (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード())
                || code.equals(NinchishoNichijoSeikatsuJiritsudoCode.記載無し.getコード()));
    }

    private boolean 認定区分と認定内容の設定B(RString code) {
        return (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード())) || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード()));
    }

    private boolean 認定区分と認定内容の設定C(RString code) {
        return (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード())) || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード()))
                || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード()));
    }

    private boolean 認定区分と認定内容の設定D(RString code) {
        return (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード())) || (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード()));
    }

    private boolean 認定区分と認定内容の設定E(RString code) {
        return (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード())) || (code.equals(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード())
                || code.equals(NinchishoNichijoSeikatsuJiritsudoCode.M.getコード()));
    }

    private boolean 認定区分と認定内容の設定G(RString code) {
        return (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード())) || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード()))
                || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード())) || (code.equals(ShogaiNichijoSeikatsuJiritsudoCode.記載無し.getコード()));
    }

}

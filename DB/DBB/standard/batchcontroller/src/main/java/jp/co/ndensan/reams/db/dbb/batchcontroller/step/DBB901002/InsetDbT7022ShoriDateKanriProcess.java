/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB901002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nendokirikae.NendoKirikaeMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ年度切替processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class InsetDbT7022ShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private NendoKirikaeProcessParameter processParameter;
    private NendoKirikaeMybatisParameter parameter;
    private static final int INT_1 = 1;
    private static final RString 連番_0001 = new RString("0001");
    private static final RString 処理名_異動賦課 = new RString("異動賦課");
    private static final RString 処理名_異動賦課確定 = new RString("異動賦課確定");
    private static final RString 処理名_仮算定異動賦課 = new RString("仮算定異動賦課");
    private static final RString 処理名_仮算定異動賦課確定 = new RString("仮算定異動賦課確定");
    private static final RString 処理名_所得引出 = new RString("所得引出");
    private static final RString 処理名_所得情報一覧表作成 = new RString("所得情報一覧表作成");
    private static final RString 処理名_調定簿作成 = new RString("調定簿作成");
    private static final RString 処理名_過年度賦課確定 = new RString("過年度賦課確定");
    private static final RString 処理名_過年度賦課 = new RString("過年度賦課");

    private List<DbT7022ShoriDateKanriEntity> 異動賦課EntityList;
    private List<DbT7022ShoriDateKanriEntity> 過年度賦課EntityList;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae."
            + "INendoKirikaeMapper.select処理日付管理マスタ");

    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected void initialize() {
        super.initialize();
        parameter = new NendoKirikaeMybatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
    }

    @Override
    protected IBatchReader createReader() {
        異動賦課EntityList = new ArrayList<>();
        過年度賦課EntityList = new ArrayList<>();
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        if (is新年度分を作成しない(entity) || 処理名_過年度賦課.equals(entity.getShoriName())) {
            if (処理名_異動賦課.equals(entity.getShoriName())) {
                異動賦課EntityList.add(entity);
            }
            if (処理名_過年度賦課.equals(entity.getShoriName())) {
                過年度賦課EntityList.add(entity);
            }
        } else {
            DbT7022ShoriDateKanriEntity newEntity = new DbT7022ShoriDateKanriEntity();
            newEntity.setSubGyomuCode(entity.getSubGyomuCode());
            newEntity.setShichosonCode(entity.getShichosonCode());
            newEntity.setShoriName(entity.getShoriName());
            newEntity.setShoriEdaban(entity.getShoriEdaban());
            newEntity.setNendo(entity.getNendo().plusYear(INT_1));
            newEntity.setNendoNaiRenban(entity.getNendoNaiRenban());
            writer.insert(newEntity);
        }
    }

    private boolean is新年度分を作成しない(DbT7022ShoriDateKanriEntity entity) {
        return 処理名_異動賦課.equals(entity.getShoriName())
                || 処理名_異動賦課確定.equals(entity.getShoriName())
                || 処理名_仮算定異動賦課.equals(entity.getShoriName())
                || 処理名_仮算定異動賦課確定.equals(entity.getShoriName())
                || 処理名_所得引出.equals(entity.getShoriName())
                || 処理名_所得情報一覧表作成.equals(entity.getShoriName())
                || 処理名_調定簿作成.equals(entity.getShoriName())
                || 処理名_過年度賦課確定.equals(entity.getShoriName());
    }

    @Override
    protected void afterExecute() {
        DbT7022ShoriDateKanriEntity 最終の異動賦課Entity = new DbT7022ShoriDateKanriEntity();
        if (null != 異動賦課EntityList && (!異動賦課EntityList.isEmpty())) {
            最終の異動賦課Entity = 異動賦課EntityList.get(0);
            for (DbT7022ShoriDateKanriEntity 異動賦課Entity : 異動賦課EntityList) {
                if (is年度内連番が最終(異動賦課Entity, 最終の異動賦課Entity)) {
                    最終の異動賦課Entity = 異動賦課Entity;
                }
            }
        }
        DbT7022ShoriDateKanriEntity 最終の過年度賦課Entity = new DbT7022ShoriDateKanriEntity();
        if (null != 過年度賦課EntityList && (!過年度賦課EntityList.isEmpty())) {
            最終の過年度賦課Entity = 過年度賦課EntityList.get(0);
            for (DbT7022ShoriDateKanriEntity 過年度賦課Entity : 過年度賦課EntityList) {
                if (is年度内連番が最終(過年度賦課Entity, 最終の過年度賦課Entity)) {
                    最終の過年度賦課Entity = 過年度賦課Entity;
                }
            }
        }

        DbT7022ShoriDateKanriEntity new過年度賦課Entity = new DbT7022ShoriDateKanriEntity();
        new過年度賦課Entity.setSubGyomuCode(最終の過年度賦課Entity.getSubGyomuCode());
        new過年度賦課Entity.setShichosonCode(最終の過年度賦課Entity.getShichosonCode());
        new過年度賦課Entity.setShoriName(最終の過年度賦課Entity.getShoriName());
        new過年度賦課Entity.setShoriEdaban(連番_0001);
        new過年度賦課Entity.setNendo(最終の過年度賦課Entity.getNendo().plusYear(INT_1));
        new過年度賦課Entity.setNendoNaiRenban(連番_0001);
        if (is最終の過年度賦課基準日時Before最終の異動賦課基準日時(最終の異動賦課Entity, 最終の過年度賦課Entity)) {
            new過年度賦課Entity.setKijunTimestamp(最終の過年度賦課Entity.getKijunTimestamp());
            new過年度賦課Entity.setTaishoKaishiTimestamp(最終の過年度賦課Entity.getTaishoKaishiTimestamp());
            new過年度賦課Entity.setTaishoShuryoTimestamp(最終の過年度賦課Entity.getTaishoShuryoTimestamp());
        } else {
            new過年度賦課Entity.setKijunTimestamp(最終の異動賦課Entity.getKijunTimestamp());
            new過年度賦課Entity.setTaishoKaishiTimestamp(最終の異動賦課Entity.getTaishoKaishiTimestamp());
            new過年度賦課Entity.setTaishoShuryoTimestamp(最終の異動賦課Entity.getTaishoShuryoTimestamp());
        }
        writer.insert(new過年度賦課Entity);
    }

    private boolean is年度内連番が最終(DbT7022ShoriDateKanriEntity 賦課Entity,
            DbT7022ShoriDateKanriEntity 最終の賦課Entity) {
        int 年度内連番_最終の賦課 = Integer.parseInt(最終の賦課Entity.getNendoNaiRenban().toString());
        int 年度内連番_賦課 = 0;
        if (null != 賦課Entity && (!RString.isNullOrEmpty(賦課Entity.getNendoNaiRenban()))) {
            年度内連番_賦課 = Integer.parseInt(賦課Entity.getNendoNaiRenban().toString());
        }
        return 年度内連番_最終の賦課 < 年度内連番_賦課;
    }

    private boolean is最終の過年度賦課基準日時Before最終の異動賦課基準日時(
            DbT7022ShoriDateKanriEntity 最終の異動賦課Entity, DbT7022ShoriDateKanriEntity 最終の過年度賦課Entity) {
        if (null == 最終の異動賦課Entity.getKijunTimestamp()) {
            return true;
        }
        if (null == 最終の過年度賦課Entity.getKijunTimestamp()) {
            return false;
        }
        return 最終の過年度賦課Entity.getKijunTimestamp().isBefore(最終の異動賦課Entity.getKijunTimestamp());
    }
}

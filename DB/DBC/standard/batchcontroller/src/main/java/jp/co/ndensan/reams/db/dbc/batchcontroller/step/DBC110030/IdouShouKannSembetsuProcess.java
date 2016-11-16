/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 異動中間高額送付データ選別です。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class IdouShouKannSembetsuProcess extends BatchProcessBase<SetaiYinEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select世帯員所得情報");
    private List<SetaiYinEntity> entityData;
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_8 = new RString("8");
    private HonnsanteiFukaProcessParamter processParameter;
    private static final RString TABLE_異動中間高額送付一時 = new RString("IdouChuukannKooGakuIttokiTemp");
    private static final RString TABLE_異動中間基本送付一時 = new RString("IdouChuukannKihonSofuIttokiTemp");
    private static final RString TABLE_異動中間償還送付一時 = new RString("IdouChuukannShouKannIttokiTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動中間基本送付一時;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動中間償還送付一時;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動中間高額送付一時;

    @Override
    protected void beforeExecute() {
        entityData = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        異動中間高額送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間高額送付一時,
                IdouChuukannKooGakuTempEntity.class);
        異動中間基本送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間基本送付一時,
                IdouChuukannKihonSofuTempEntity.class);
        異動中間償還送付一時 = new BatchEntityCreatedTempTableWriter(TABLE_異動中間償還送付一時,
                IdouChuukannShouKannTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(SetaiYinEntity entity) {
        entityData.add(entity);
    }

    @Override
    protected void afterExecute() {
        List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付情報 = HonnSanteiFukaManager.createInstance().
                set異動中間基本送付(processParameter.get処理対象年月(), processParameter.get合併区分());
        Collections.sort(異動中間基本送付情報, new Comparator<IdouChuukannKihonSofuTempEntity>() {
            @Override
            public int compare(IdouChuukannKihonSofuTempEntity entity1, IdouChuukannKihonSofuTempEntity entity2) {
                FlexibleDate str1 = entity1.get異動年月日();
                FlexibleDate str2 = entity2.get異動年月日();
                return str2.compareTo(str1);
            }
        });
        List<IdouChuukannShouKannTempEntity> 異動中間償還送付情報 = HonnSanteiFukaManager.createInstance().
                set異動中間償還送付(processParameter.get処理対象年月(), processParameter.get合併区分());
        Collections.sort(異動中間償還送付情報, new Comparator<IdouChuukannShouKannTempEntity>() {
            @Override
            public int compare(IdouChuukannShouKannTempEntity entity1, IdouChuukannShouKannTempEntity entity2) {
                FlexibleDate str1 = entity1.get異動年月日();
                FlexibleDate str2 = entity2.get異動年月日();
                return str2.compareTo(str1);
            }
        });
        List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報 = HonnSanteiFukaManager.createInstance().
                set異動中間高額送付(processParameter.get処理対象年月(), processParameter.get合併区分());
        Collections.sort(異動中間高額送付情報, new Comparator<IdouChuukannKooGakuTempEntity>() {
            @Override
            public int compare(IdouChuukannKooGakuTempEntity entity1, IdouChuukannKooGakuTempEntity entity2) {
                FlexibleDate str1 = entity1.get異動年月日();
                FlexibleDate str2 = entity2.get異動年月日();
                return str2.compareTo(str1);
            }
        });
        if (異動中間高額送付情報 != null && !異動中間高額送付情報.isEmpty()) {
            for (IdouChuukannKooGakuTempEntity 異動中間高額 : 異動中間高額送付情報) {
                if (entityData.isEmpty()) {
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(区分_8);
                    builder.append(異動中間高額.get被保険者番号().value().substring(1));
                    異動中間高額.set世帯集約番号(new HihokenshaNo(builder.toRString()));
                    異動中間高額.set世帯所得区分コード(区分_2);
                    異動中間高額.set所得区分コード(区分_2);
                    異動中間高額.set老齢福祉年金受給有フラグ(false);
                    異動中間高額.set利用者負担第２段階有フラグ(false);
                    異動中間高額.set激変緩和境界層区分(区分_0);
                }
                for (SetaiYinEntity entity : entityData) {
                    if (異動中間高額.get被保険者番号().equals(entity.getHihokenshaNo())
                            && 異動中間高額.get基準年月日().equals(entity.getJukyuYMD())) {
                        HonnSanteiFukaManager.createInstance().set高額選別情報(異動中間高額, entity, entityData,
                                processParameter.get処理対象年月());
                    }
                }
            }
        }
        if (異動中間高額送付情報 != null && !異動中間高額送付情報.isEmpty() && 1 < 異動中間高額送付情報.size()) {
            get異動中間高額送付(異動中間基本送付情報, 異動中間償還送付情報, 異動中間高額送付情報);
        }
        set異動中間高額送付(異動中間基本送付情報, 異動中間償還送付情報, 異動中間高額送付情報);

    }

    private void get異動中間高額送付(List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付情報,
            List<IdouChuukannShouKannTempEntity> 異動中間償還送付情報,
            List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報) {
        RString 最新世帯集約番号 = 異動中間高額送付情報.get(0).get世帯集約番号() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(0).get世帯集約番号().value();
        RString 最新世帯所得区分 = 異動中間高額送付情報.get(0).get世帯所得区分コード() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(0).get世帯所得区分コード();
        RString 最新所得区分 = 異動中間高額送付情報.get(0).get所得区分コード() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(0).get所得区分コード();
        RString 過去世帯集約番号 = 異動中間高額送付情報.get(1).get世帯集約番号() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(1).get世帯集約番号().value();
        RString 過去世帯所得区分 = 異動中間高額送付情報.get(1).get世帯所得区分コード() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(1).get世帯所得区分コード();
        RString 過去所得区分 = 異動中間高額送付情報.get(1).get所得区分コード() == null
                ? RString.EMPTY : 異動中間高額送付情報.get(1).get所得区分コード();
        RString 最新の情報 = 異動中間高額送付情報.get(0).get証記載保険者番号().value().concat(最新世帯集約番号)
                .concat(最新世帯所得区分).concat(最新所得区分);
        RString 過去の情報 = 異動中間高額送付情報.get(1).get証記載保険者番号().value()
                .concat(過去世帯集約番号).concat(過去世帯所得区分).concat(過去所得区分);
        RString 最新の証記載保険者番号 = 最新世帯集約番号.concat(最新世帯所得区分).concat(最新所得区分);
        RString 過去の証記載保険者番号 = 過去世帯集約番号.concat(過去世帯所得区分).concat(過去所得区分);
        if (最新の情報.equals(過去の情報) && 異動中間高額送付情報.get(0).is老齢福祉年金受給有フラグ() == 異動中間高額送付情報.get(1)
                .is老齢福祉年金受給有フラグ() && 異動中間高額送付情報.get(0).is利用者負担第２段階有フラグ() == 異動中間高額送付情報.get(1)
                .is利用者負担第２段階有フラグ()) {
            異動中間基本送付情報.remove(0);
            異動中間償還送付情報.remove(0);
            異動中間高額送付情報.remove(0);
        } else if (最新の証記載保険者番号.equals(過去の証記載保険者番号) && 異動中間高額送付情報.get(0).is老齢福祉年金受給有フラグ()
                == 異動中間高額送付情報.get(1).is老齢福祉年金受給有フラグ()
                && 異動中間高額送付情報.get(0).is利用者負担第２段階有フラグ() == 異動中間高額送付情報.get(1).is利用者負担第２段階有フラグ()) {
            異動中間償還送付情報.remove(0);
        }
    }

    private void set異動中間高額送付(List<IdouChuukannKihonSofuTempEntity> 異動中間基本送付情報,
            List<IdouChuukannShouKannTempEntity> 異動中間償還送付情報,
            List<IdouChuukannKooGakuTempEntity> 異動中間高額送付情報) {
        for (IdouChuukannKihonSofuTempEntity 基本送付情報 : 異動中間基本送付情報) {
            異動中間基本送付一時.insert(基本送付情報);
        }
        for (IdouChuukannShouKannTempEntity 償還送付情報 : 異動中間償還送付情報) {
            異動中間償還送付一時.insert(償還送付情報);
        }
        if (異動中間高額送付情報 != null && !異動中間高額送付情報.isEmpty()) {
            for (IdouChuukannKooGakuTempEntity 高額送付情報 : 異動中間高額送付情報) {
                異動中間高額送付一時.insert(高額送付情報);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.KozaKyomuBetsuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.SofuFileSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoInsertKozaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060.IKogakugassanShikyushinseishoOutMapper;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成の口座情報登録確認Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutInsertKozaProcess extends BatchProcessBase<KogakuGassanShinseishoInsertKozaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get口座情報がないデータ");
    private static final RString 高額合算申請書一時TABLE_NAME = new RString("DbWT3711KogakuGassanShinseisho");
    private static final RString 処理結果リスト一時TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算申請書一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    private SofuFileSakuseiMybatisParameter mybatisParameter;

    private KogakuGassanShinseishoInsertKozaEntity beforeEntity;

    @Override
    protected void initialize() {
        IKogakugassanShikyushinseishoOutMapper mapper = getMapper(IKogakugassanShikyushinseishoOutMapper.class);
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額合算 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_高額合算);
        KozaKyomuBetsuMybatisParameter mybatis = new KozaKyomuBetsuMybatisParameter();
        mybatis.set科目コード(介護給付_高額合算.getコード());
        RString 主キー = mapper.get業務別主キー(mybatis);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額合算.getコード())
                .set業務別主キー(主キー)
                .set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()))
                .set基準日(new FlexibleDate(RDate.getNowDate().toDateString())).build();
        List<KamokuCode> kamokuList = new ArrayList<>();
        kamokuList.add(介護給付_高額合算.getコード());
        mybatisParameter = new SofuFileSakuseiMybatisParameter(null, searchKey, kamokuList);
    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        高額合算申請書一時tableWriter = new BatchEntityCreatedTempTableWriter(高額合算申請書一時TABLE_NAME,
                DbWT3711KogakuGassanShinseishoTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TABLE_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanShinseishoInsertKozaEntity entity) {
        DbWT3711KogakuGassanShinseishoTempEntity tempEntity;
        tempEntity = entity.get高額合算申請書一時Entity();
        if (!tempEntity.isSofuJogaiFlag()) {
            tempEntity.setSofuJogaiFlag(true);
            高額合算申請書一時tableWriter.update(tempEntity);
        }
        if (beforeEntity == null
                || !beforeEntity.get高額合算申請書一時Entity().getShoKisaiHokenshaNo().equals(tempEntity.getShoKisaiHokenshaNo())
                || !beforeEntity.get高額合算申請書一時Entity().getHihokenshaNo().equals(tempEntity.getHihokenshaNo())
                || !beforeEntity.get高額合算申請書一時Entity().getShikyuShinseishoSeiriNo().equals(tempEntity.getShikyuShinseishoSeiriNo())
                || beforeEntity.get高額合算申請書一時Entity().getKozaID() != tempEntity.getKozaID()) {
            処理結果リスト一時tableWriter.insert(setKokuhorenSakuseiError(entity.get高額合算申請書一時Entity(),
                    entity.get被保険者一時Entity()));
        }
        beforeEntity = entity;
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity setKokuhorenSakuseiError(DbWT3711KogakuGassanShinseishoTempEntity entity,
            DbWT1001HihokenshaTempEntity dbwt1001Entity) {
        DbWT1002KokuhorenSakuseiErrorTempEntity tempEntity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        tempEntity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.口座情報取得エラー.getコード());
        tempEntity.setShoHokanehshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setKey1(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setKey2(new RString(entity.getKozaID()));
        tempEntity.setKey3(RString.EMPTY);
        tempEntity.setKey4(RString.EMPTY);
        tempEntity.setKey5(RString.EMPTY);
        tempEntity.setHihokenshaKanaShimei(dbwt1001Entity.getKanaMeisho());
        tempEntity.setHihokenshaShimei(dbwt1001Entity.getMeisho());
        return tempEntity;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitateshouut.SaishinsaMoshitateshoOutSofuDataGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateGetSoufuDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護給付費再審査申立書情報作成・送付対象データ取得を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateGetSoufuDataProcess extends BatchProcessBase<DbWT1741SaishinsaMoshitateTempEntity> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<SaishinsaMoshitateshoOutSofuDataGetReturnEntity> flowEntity;
    private SaishinsaMoshitateshoOutSofuDataGetReturnEntity returnEntity;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select再審査申立データリスト");
    private SaishinsaMoshitateGetSoufuDataProcessParameter parameter;
    private SaishinsaMoshitateMybatisParameter mybatisParameter;
    private int 連番;
    private static final Integer INDEX_0 = 0;
    private static final RString エラー区分_送付対象なし = new RString("01");
    private ShoKisaiHokenshaNo 保険者番号;
    private RString 保険者名称;

    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 再審査申立一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 再審査申立一時_TABLE_NAME = new RString("DbWT1741SaishinsaMoshitate");

    @Override
    protected void initialize() {

        mybatisParameter = new SaishinsaMoshitateMybatisParameter();
        mybatisParameter.set再処理区分(parameter.get再処理区分());
        mybatisParameter.set処理年月(parameter.get処理年月());
        returnEntity = new SaishinsaMoshitateshoOutSofuDataGetReturnEntity();
        連番 = 0;
        保険者番号 = new ShoKisaiHokenshaNo(DbBusinessConfig
                .get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        保険者名称 = ConfigNameDBU.保険者情報_保険者番号.get名称();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT1001HihokenshaEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT1002KokuhorenSakuseiErrorTempEntity.class);
        再審査申立一時tableWriter
                = new BatchEntityCreatedTempTableWriter(再審査申立一時_TABLE_NAME, DbWT1741SaishinsaMoshitateEntity.class);
    }

    @Override
    protected void process(DbWT1741SaishinsaMoshitateTempEntity entity) {
        連番 = 連番 + 1;
        insert再審査申立一時TBL(entity);
        insert被保険者一時TBL(entity);
    }

    @Override
    protected void afterExecute() {

        if (連番 == INDEX_0) {
            DbWT1002KokuhorenSakuseiErrorTempEntity errorTempentity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
            errorTempentity.setErrorKubun(エラー区分_送付対象なし);
            errorTempentity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            errorTempentity.setHihokenshaNo(HihokenshaNo.EMPTY);
            errorTempentity.setKey1(RString.EMPTY);
            errorTempentity.setKey2(RString.EMPTY);
            errorTempentity.setKey3(RString.EMPTY);
            errorTempentity.setKey4(RString.EMPTY);
            errorTempentity.setKey5(RString.EMPTY);
            errorTempentity.setHihokenshaKanaShimei(RString.EMPTY);
            errorTempentity.setHihokenshaShimei(RString.EMPTY);
            errorTempentity.setBiko(RString.EMPTY);
            errorTempentity.setState(EntityDataState.Added);
            処理結果リスト一時tableWriter.insert(errorTempentity);
        }
        returnEntity.setレコード件数合算(連番);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void insert再審査申立一時TBL(DbWT1741SaishinsaMoshitateTempEntity entity) {

        DbWT1741SaishinsaMoshitateEntity 明細データ = new DbWT1741SaishinsaMoshitateEntity();
        明細データ.setRenban(連番);
        明細データ.setJigyoshoNo(entity.get事業所番号());
        明細データ.setHiHokenshaNo(entity.get被保険者番号());
        明細データ.setServiceTeikyoYM(entity.getサービス提供年月());
        明細データ.setServiceTeikyoShuruiCode(entity.getサービス種類コード());
        明細データ.setServiceKomokuCode(entity.getサービス項目コード());
        明細データ.setRirekiNo(entity.get履歴番号());
        明細データ.setMoshitateYMD(entity.get申立年月日());
        明細データ.setMoshitateshaKubunCode(entity.get申立者区分コード());
        明細データ.setShokisaiHokenshaNo(entity.get証記載保険者番号());
        明細データ.setMoshitateTanisu(entity.get申立単位数());
        明細データ.setMoshitateJiyuCode(entity.get申立事由コード());
        明細データ.setKokuhorenSofuYM(entity.get国保連送付年月());
        明細データ.setKokuhirenSaiSofuAriFlag(entity.is国保連再送付有フラグ());
        明細データ.setBiko(entity.get備考());
        明細データ.setHokenshaNo(HokenshaNo.EMPTY);
        明細データ.setHokenshaName(RString.EMPTY);
        if (保険者番号.equals(entity.get証記載保険者番号())) {
            明細データ.setShokisaiHokenshaName(保険者名称);
        } else {
            明細データ.setShokisaiHokenshaName(RString.EMPTY);
        }
        明細データ.setJigyoshaName(RString.EMPTY);
        明細データ.setServiceMeisho(RString.EMPTY);
        明細データ.setSofuJogaiFlag(false);
        明細データ.setState(EntityDataState.Added);
        再審査申立一時tableWriter.insert(明細データ);

    }

    private void insert被保険者一時TBL(DbWT1741SaishinsaMoshitateTempEntity entity) {

        DbWT1001HihokenshaEntity 被保険者明細 = new DbWT1001HihokenshaEntity();
        被保険者明細.setExRenban(連番);
        被保険者明細.setExHokenshaNo(HokenshaNo.EMPTY);
        被保険者明細.setExHokenshaName(RString.EMPTY);
        被保険者明細.setExShoHokenshaNo(entity.get証記載保険者番号());
        被保険者明細.setExHihokenshaNo(entity.get被保険者番号());
        被保険者明細.setExServiceTeikyoYm(entity.getサービス提供年月());
        被保険者明細.setHenkanFlag(false);
        被保険者明細.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者明細.setSofuHihokenshaNo(entity.get被保険者番号());
        被保険者明細.setShichosonCode(LasdecCode.EMPTY);
        被保険者明細.setKannaiKangaiKubun(RString.EMPTY);
        被保険者明細.setYubinNo(RString.EMPTY);
        被保険者明細.setChoikiCode(RString.EMPTY);
        被保険者明細.setGyoseikuCode(RString.EMPTY);
        被保険者明細.setGyoseikuMei(RString.EMPTY);
        被保険者明細.setJusho(RString.EMPTY);
        被保険者明細.setBanchi(RString.EMPTY);
        被保険者明細.setKatagaki(RString.EMPTY);
        被保険者明細.setKanaMeisho(RString.EMPTY);
        被保険者明細.setMeisho(RString.EMPTY);
        被保険者明細.setShimei50onKana(RString.EMPTY);
        被保険者明細.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者明細.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者明細.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者明細.setSetaiShuyakuNo(RString.EMPTY);
        被保険者明細.setSeinenYmd(FlexibleDate.EMPTY);
        被保険者明細.setSeibetsuCode(RString.EMPTY);
        被保険者明細.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        被保険者明細.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        被保険者明細.setState(EntityDataState.Added);
        被保険者一時tableWriter.insert(被保険者明細);
    }
}

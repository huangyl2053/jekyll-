/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.HihokenshaDaichoShinseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請情報償還一時テーブルデータの取得、申請償還情報に付与します。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class ShokanJyohoForShinseiJyohoProcess extends BatchProcessBase<HihokenshaDaichoShinseiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get申請情報償還For申請情報");
    private static final RString TABLE_NAME = new RString("ShinseiJohoTemp");
    private static final RString MENU_ID_DBCMN43001 = new RString("DBCMN43001");
    private static final RString MENU_ID_DBCMNL3001 = new RString("DBCMNL3001");
    private static final RString 国保連共同処理受託区分_高額_ONE = new RString("1");
    private static final RString 国保連共同処理受託区分_事業高額_ONE = new RString("1");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;
    private RString 審査方法区分;
    private RString 高額;
    private RString 事業高額;

    @Override
    protected void initialize() {
        審査方法区分 = BusinessConfig.get(ConfigNameDBC.償還支給申請書_審査方法初期表示, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        高額 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        事業高額 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_事業高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    @BatchWriter
    private IBatchTableWriter<ShinseiJohoTempEntity> tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoTempEntity.class);
    }

    @Override
    protected void process(HihokenshaDaichoShinseiRelateEntity entity) {
        ShinseiJohoTempEntity 申請情報 = entity.get申請情報();
        申請情報.setShinseiYMDJoho(parameter.getShiseibi());
        申請情報.setShinseishaKubunJoho(ShinseishaKubun.本人.getコード());
        申請情報.setShinseishaShimeiJoho(entity.get申請情報償還().getShinseishaShimeiShokan());
        申請情報.setShinseishaShimeiKanaJoho(entity.get申請情報償還().getShinseishaShimeiKanaShokan());
        申請情報.setShiharaiSumiKingakuGokeiJoho(entity.get申請情報償還().getRiyoshaFutanGakuGokeiShokan());
        申請情報.setUketsukeYMDJoho(parameter.getUketsukebi());
        申請情報.setKetteiYMDJoho(parameter.getKeteibi());
        申請情報.setHonninShiharaiGakuJoho(entity.get申請情報償還().getRiyoshaFutanGakuGokeiShokan());
        申請情報.setHanteiKekkaShikyuKubunCodeJoho(ShikyuKubun.支給.getコード());
        申請情報.setShikyuKingakuJoho(entity.get申請情報償還().getGokeiKogakuShikyuGakuShokan());
        申請情報.setShinsaHohoKubunJoho(審査方法区分);
        申請情報.setKetteiRiyoshaFutanGakuJoho(Decimal.ZERO);
        申請情報.setShiharaiHohoKubunCodeJoho(ShiharaiHohoKubun.口座払.getコード());
        申請情報.setKozaIDJoho(entity.get申請情報償還().getKozaIDShokan());
        申請情報.setJidoShokanTaishoFlagJoho(true);
        if (!parameter.isJutakuAri()) {
            申請情報.setHanteiKekkaSofuYMJoho(FlexibleDate.getNowDate().getYearMonth());
            申請情報.setKetteishaUketoriYMJoho(FlexibleDate.getNowDate().getYearMonth());
        } else if (MENU_ID_DBCMN43001.equals(parameter.getMenuId()) && 国保連共同処理受託区分_高額_ONE.equals(高額)
                && (申請情報.getHanteiKekkaSofuYMJoho() == null || 申請情報.getHanteiKekkaSofuYMJoho().isEmpty())) {
            申請情報.setHanteiKekkaSofuYMJoho(FlexibleDate.getNowDate().getYearMonth());
            申請情報.setKetteishaUketoriYMJoho(FlexibleDate.getNowDate().getYearMonth());
        } else if (MENU_ID_DBCMNL3001.equals(parameter.getMenuId()) && 国保連共同処理受託区分_事業高額_ONE.equals(事業高額)
                && (申請情報.getHanteiKekkaSofuYMJoho() == null || 申請情報.getHanteiKekkaSofuYMJoho().isEmpty())) {
            申請情報.setHanteiKekkaSofuYMJoho(FlexibleDate.getNowDate().getYearMonth());
            申請情報.setKetteishaUketoriYMJoho(FlexibleDate.getNowDate().getYearMonth());
        } else {
            申請情報.setHanteiKekkaSofuYMJoho(FlexibleYearMonth.EMPTY);
            申請情報.setKetteishaUketoriYMJoho(FlexibleYearMonth.EMPTY);
        }
        申請情報.setState(EntityDataState.Modified);
        tempDbWriter.update(申請情報);
    }
}

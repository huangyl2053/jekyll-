/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyuketteitsuchisho.IKogakugassanShikyuKetteitsuchishoMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタを更新processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class UpdateDbT7022Process extends SimpleBatchProcessBase {

    private KogakugassanShikyuKetteitsuchishoProcessParameter processParameter;
    private static final RString 日付選択区分_受取年月 = new RString("1");
    private static final RString 日付選択区分_申請年月日 = new RString("2");
    private static final RString 処理枝番_受取年月 = new RString("0001");
    private static final RString 処理枝番_申請年月日 = new RString("0002");
    private static final RString 処理枝番_決定年月日 = new RString("0003");
    private static final RString 日_01 = new RString("01");

    @Override
    protected void process() {
        KogakugassanShikyuKetteitsuchishoMybatisParameter updateParameter
                = new KogakugassanShikyuKetteitsuchishoMybatisParameter();
        // TODO QA1508
        updateParameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (地方公共団体 != null) {
            updateParameter.set市町村コード(地方公共団体.get地方公共団体コード());
        }
        updateParameter.set処理名(ShoriName.高額合算自己負担額計算登録.get名称());
        if (日付選択区分_受取年月.equals(processParameter.get日付選択区分())) {
            updateParameter.set処理枝番(処理枝番_受取年月);
        } else if (日付選択区分_申請年月日.equals(processParameter.get日付選択区分())) {
            updateParameter.set処理枝番(処理枝番_申請年月日);
        } else {
            updateParameter.set処理枝番(処理枝番_決定年月日);
        }
        updateParameter.set受取年月_01(new FlexibleDate(processParameter.get受取年月().toDateString().concat(日_01)));
        updateParameter.set申請開始年月日(processParameter.get申請開始年月日());
        updateParameter.set申請終了年月日(processParameter.get申請終了年月日());
        updateParameter.set決定開始年月日(processParameter.get決定開始年月日());
        updateParameter.set決定終了年月日(processParameter.get決定終了年月日());
        getMapper(IKogakugassanShikyuKetteitsuchishoMapper.class).update処理日付管理マスタ(updateParameter);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KeisangojohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 PrintService
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranPrintService {

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド
     *
     * @param 更正前後EntityList KeisangojohoAtenaKozaKouseizengoEntityのList
     * @param バッチパラメータ HonSanteiIdoKanendoFukaBatchParameter
     * @param 調定日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時) {
        KanendoIdouKekkaIchiranProperty property = new KanendoIdouKekkaIchiranProperty();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association = associationFinder.getAssociation();
        return new Printer<KanendoIdouKekkaIchiranSource>().spool(property,
                new KanendoIdouKekkaIchiranReport(更正前後EntityList, バッチパラメータ, 調定日時, association));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaishiryoa4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryoa4.ShinsakaishiryoA4Parameter;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4Entity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;

/**
 * 事務局用介護認定審査対象者一覧表のMapperです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public interface IShinsakaishiryoA4Mapper {

    /**
     * 審査員一覧取得の取得処理です。
     *
     * @param parameter 事務局用介護認定審査対象者一覧表のParameterクラス
     * @return List<RString>
     */
    List<AtenaMeisho> get審査員一覧取得(ShinsakaishiryoA4Parameter parameter);

    /**
     * 審査対象者一覧の取得処理です。
     *
     * @param parameter 事務局用介護認定審査対象者一覧表のParameterクラス
     * @return List<ShinsakaishiryoA4Entity>
     */
    List<ShinsakaishiryoA4Entity> get審査対象者一覧(ShinsakaishiryoA4Parameter parameter);

}

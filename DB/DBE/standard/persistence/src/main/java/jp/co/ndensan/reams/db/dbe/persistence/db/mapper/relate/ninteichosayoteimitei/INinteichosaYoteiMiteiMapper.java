/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosayoteimitei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyoikenshochecklist.ChosahyoIkenshoCheckListParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairaihenko.NinteichosaIraiHenkoMiteiParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosayoteimitei.NinteichosaYoteiMiteiParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaihenko.NinteichosaIraiHenkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei.NinteichosaYoteiMiteiRelateEntity;

/**
 * 認定調査予定未定者一覧表のデータ取得のMapperクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
public interface INinteichosaYoteiMiteiMapper {

    /**
     * 認定調査予定未定者一覧表のデータ取得します。
     *
     * @param paramter 認定調査予定未定者一覧表のデータ取得パラメータ
     * @return 認定調査予定未定者一覧表
     */
    List<NinteichosaYoteiMiteiRelateEntity> getNinteichosaScheduleInput(NinteichosaYoteiMiteiParamter paramter);

    /**
     * 認定調査依頼先変更者一覧表のデータ取得します。
     *
     * @param paramter 認定調査依頼先変更者一覧表のデータ取得パラメータ
     * @return 認定調査依頼先変更者一覧表
     */
    List<NinteichosaIraiHenkoRelateEntity> getNinteichosaIraiHenko(NinteichosaIraiHenkoMiteiParamter paramter);

    /**
     * 認定調査結果と主治医意見書のチェックリストのデータ取得します。
     *
     * @param paramter 認定調査結果と主治医意見書のチェックリストのデータ取得パラメータ
     * @return 認定調査結果と主治医意見書のチェックリスト
     */
    List<ChosahyoIkenshoCheckListRelateEntity> getChosahyoIkenshoCheckList(ChosahyoIkenshoCheckListParamter paramter);

    /**
     * 認定調査依頼先変更者一覧表のデータの条数を取得します。
     *
     * @param paramter 認定調査依頼先変更者一覧表のデータ取得パラメータ
     * @return 条数
     */
    int getCount(NinteichosaIraiHenkoMiteiParamter paramter);
}

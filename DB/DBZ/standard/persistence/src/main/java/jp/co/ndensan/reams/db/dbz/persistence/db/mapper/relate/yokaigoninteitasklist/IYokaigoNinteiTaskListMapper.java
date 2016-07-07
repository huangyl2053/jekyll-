/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteitasklist;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.CyoSaNyuSyuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.CyoSaiRaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.GeTuReiSyoRiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IChiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IKnSyoiRaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IkenSyoNyuSyuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.KoShiTaisyoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.MaSuKinGuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.NiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShiSeiKeTuKeRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelate;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKeTuKeRelateEntity;

/**
 * 要介護認定申請情報＆構成市町村マスタ検索のインタフェイスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public interface IYokaigoNinteiTaskListMapper {

    /**
     * 更新対象モードによって、要介護認定申請情報＆構成市町村マスタを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<KoShiTaisyoRelateEntity>
     */
    List<KoShiTaisyoRelateEntity> get更新対象(YokaigoNinteiTaskListParameter parameter);

    /**
     * 申請受付モードによって、要介護認定申請情報＆構成市町村マスタ ＆要介護認定完了情報＆認定調査依頼情報を取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShiSeiKeTuKeRelateEntity>
     */
    List<ShiSeiKeTuKeRelateEntity> get申請受付(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆ 要介護認定申請情報＆要介護認定完了情報＆
     * 構成市町村マスタ＆認定調査依頼情報＆介護事業者＆認定調査委託先情報＆認定調査委託先情報＆調査員情報＆ 認定調査委託先情報を取得する。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<CyoSaiRaiRelateEntity>
     */
    List<CyoSaiRaiRelateEntity> get調査依頼(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆ 要介護認定申請情報＆要介護認定完了情報＆
     * 構成市町村マスタ＆認定調査依頼情報＆介護事業者＆認定調査委託先情報＆認定調査委託先情報＆調査員情報＆ 認定調査委託先情報を取得する。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前調査依頼(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆要介護認定完了情報＆構成市町村マスタ＆介護事業者＆
     * 主治医意見書作成依頼情報＆要介護認定主治医意見書情報＆主治医医療機関情報＆主治医情報＆主治医医療機関情報＆主治医情報を取得する。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<IKnSyoiRaiRelateEntity>
     */
    List<IKnSyoiRaiRelateEntity> get意見書依頼(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆要介護認定完了情報＆構成市町村マスタ＆介護事業者＆
     * 主治医意見書作成依頼情報＆要介護認定主治医意見書情報＆主治医医療機関情報＆主治医情報＆主治医医療機関情報＆主治医情報を取得する。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前意見書依頼(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ＆ 認定調査依頼情報＆認定調査票（概況調査）＆認定調査委託先情報＆調査員情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<CyoSaNyuSyuRelateEntity>
     */
    List<CyoSaNyuSyuRelateEntity> get調査入手(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ ＆
     * 認定調査依頼情報＆認定調査票（概況調査）＆認定調査委託先情報＆調査員情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前調査入手(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ
     * ＆主治医意見書作成依頼情報＆要介護認定主治医意見書情報＆主治医医療機関情報＆主治医情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<IkenSyoNyuSyuRelateEntity>
     */
    List<IkenSyoNyuSyuRelateEntity> get意見書入手(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ
     * ＆主治医意見書作成依頼情報＆要介護認定主治医意見書情報＆主治医医療機関情報＆主治医情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前意見書入手(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆構成市町村マスタ＆要介護認定完了情報＆要介護認定一次判定結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<IChiJiHanTeiRelateEntity>
     */
    List<IChiJiHanTeiRelateEntity> get一次判定(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆構成市町村マスタ＆要介護認定完了情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<MaSuKinGuRelateEntity>
     */
    List<MaSuKinGuRelateEntity> getマスキング(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆構成市町村マスタ＆要介護認定完了情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前マスキング(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&介護認定審査会割当情報&介護認定審査会開催予定情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelateEntity>
     */
    List<ShinSaKaiToRoKuRelateEntity> get審査会登録(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&介護認定審査会割当情報&介護認定審査会開催予定情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelateEntity>
     */
    List<ShinSaKaiToRoKuRelate> get前審査会登録(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&要介護認定結果情報&介護認定審査会割当情報
     * &介護認定審査会開催予定情報&介護認定審査会開催結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<NiJiHanTeiRelateEntity>
     */
    List<NiJiHanTeiRelateEntity> get二次判定(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&要介護認定結果情報&介護認定審査会割当情報
     * &介護認定審査会開催予定情報&介護認定審査会開催結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前二次判定(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&要介護認定結果情報&介護認定審査会割当情報
     * &介護認定審査会開催予定情報&介護認定審査会開催結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<GeTuReiSyoRiRelateEntity>
     */
    List<GeTuReiSyoRiRelateEntity> get月例処理(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&要介護認定結果情報&介護認定審査会割当情報
     * &介護認定審査会開催予定情報&介護認定審査会開催結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前月例処理(YokaigoNinteiTaskListParameter parameter);

    /**
     * 審査受付モードによって、要介護認定申請情報＆構成市町村マスタを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKeTuKeRelateEntity>
     */
    List<ShinSaKeTuKeRelateEntity> get審査受付(YokaigoNinteiTaskListParameter parameter);

    /**
     * 審査受付モードによって、要介護認定申請情報＆構成市町村マスタを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前審査受付(YokaigoNinteiTaskListParameter parameter);

    /**
     * 要介護認定申請情報＆構成市町村マスタ＆要介護認定完了情報＆要介護認定一次判定結果情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinSaKaiToRoKuRelate>
     */
    List<ShinSaKaiToRoKuRelate> get前一次判定(YokaigoNinteiTaskListParameter parameter);
}

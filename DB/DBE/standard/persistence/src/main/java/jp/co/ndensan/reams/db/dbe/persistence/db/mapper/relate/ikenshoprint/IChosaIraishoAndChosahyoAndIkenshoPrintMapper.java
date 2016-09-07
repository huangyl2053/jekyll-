/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoprint;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷のマッパーインタフェースです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public interface IChosaIraishoAndChosahyoAndIkenshoPrintMapper {

    /**
     * 認定調査依頼情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 認定調査依頼情報リスト
     */
    List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> select認定調査依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 主治医意見書依頼情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 主治医意見書依頼情報リスト
     */
    List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> select主治医意見書依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 認定調査依頼情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 更新用認定調査依頼情報リスト
     */
    List<DbT5201NinteichosaIraiJohoEntity> select更新用認定調査依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 主治医意見書依頼情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 更新用主治医意見書依頼情報リスト
     */
    List<DbT5301ShujiiIkenshoIraiJohoEntity> select更新用主治医意見書依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 認定調査依頼書情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 認定調査依頼書情報
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select認定調査依頼書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 認定調査依頼一覧表情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 認定調査依頼一覧表情報
     */
    List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> select認定調査依頼一覧表(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 認定調査票_概況調査情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 認定調査票_概況調査情報
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select認定調査票_概況調査(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 認定調査票差異チェック票情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 認定調査票差異チェック票情報
     */
    List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> select認定調査票差異チェック票(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 意見書作成依頼書票情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 意見書作成依頼書情報
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select意見書作成依頼書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 意見書作成依頼一覧表情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 意見書作成依頼一覧表情報
     */
    List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> select意見書作成依頼一覧表(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 主治医意見書記入用紙情報を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 主治医意見書記入用紙情報
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select主治医意見書記入用紙(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 主治医意見書作成料請求書を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 主治医意見書作成料請求書
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select主治医意見書作成料請求書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);

    /**
     * 介護保険診断命令書を検索します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return 介護保険診断命令書
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintEntity select介護保険診断命令書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter);
}

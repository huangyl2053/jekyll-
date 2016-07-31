/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairai.NinteichosaIraiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileChosainRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;

/**
 * 完了処理・認定調査依頼のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public interface INinteichosaIraiMapper {

    /**
     * 画面選択した保険者番号より、認定調査委託先情報を検索します。
     *
     * @param parameter 検索パラメータ
     * @return 認定調査委託先情報検索結果件数
     */
    int select認定調査委託先情報(NinteichosaIraiParameter parameter);

    /**
     * 画面選択した保険者番号より、調査可能人数を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 調査可能人数
     */
    int select調査可能人数(NinteichosaIraiParameter parameter);

    /**
     * 画面選択した保険者番号より、割付済人数を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 割付済人数
     */
    int select割付済人数(NinteichosaIraiParameter parameter);

    /**
     * 画面選択した保険者番号より、要割付委託先と調査員を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 調査員情報
     */
    List<DbT5913ChosainJohoEntity> select委託先調査員情報(NinteichosaIraiParameter parameter);

    /**
     * 画面選択した申請書管理番号より、最大の認定調査依頼履歴番号を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 最大の認定調査依頼履歴番号
     */
    int selectMax認定調査依頼履歴番号(NinteichosaIraiParameter parameter);

    /**
     * モバイルデータの申請書管理番号より、最新認定調査依頼情報を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 最新認定調査依頼情報
     */
    DbT5201NinteichosaIraiJohoEntity select最新認定調査依頼情報(NinteichosaIraiParameter parameter);

    /**
     * 選択された行の申請書管理番号条件として、調査結果入力用データを取得を取得します。
     *
     * @param parameter 検索パラメータ
     * @return 調査結果入力用データ
     */
    List<ChosaKekkaNyuryokuMobileRelateEntity> select調査結果入力用データ(NinteichosaIraiParameter parameter);

    /**
     * 選択された行の申請書管理番号条件として、調査結果入力用調査員データを取得します。
     *
     * @return 調査結果入力用調査員データ
     */
    List<ChosaKekkaNyuryokuMobileChosainRelateEntity> select調査結果入力用調査員データ();

}

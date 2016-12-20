/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ininnteichousairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.SaiChekkuhyoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.NinteichosaIraiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.SaiChekkuhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.WaritsukeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public interface INinnteiChousairaiMapper {

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> select認定調査委託先情報(NinnteiChousairaiParameter parametere);

    /**
     * 調査員情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> select調査員(NinnteiChousairaiParameter parametere);

    /**
     * 割付済み申請者一覧を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> select割付済み申請者(NinnteiChousairaiParameter parametere);

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    NinteichosaIraiJohoRelateEntity getNinteichosaIraiJohoList(NinnteiChousairaiParameter parametere);

    /**
     * 未割付申請者一覧（新規依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> select新規依頼未割付申請者(NinnteiChousairaiParameter parametere);

    /**
     * 未割付申請者一覧（再依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> select再依頼未割付申請者(NinnteiChousairaiParameter parametere);

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号。
     * @return WaritsukeEntity 認定調査依頼情報Entity
     */
    DbT5201NinteichosaIraiJohoEntity select認定調査依頼情報(RString 申請書管理番号);

    /**
     * 認定調査票差異チェック票を取得します。
     *
     * @param parameter SaiChekkuhyoParameter。
     * @return SaiChekkuhyoEntity 認定調査票差異チェック票Entity
     */
    List<SaiChekkuhyoEntity> get認定調査票差異チェック票情報(SaiChekkuhyoParameter parameter);
}

package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shokaishukirokukanri;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 共有子Div「証回収記録管理」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShoKaishuKirokuKanriDiv {

    /**
     * 引数で指定したキーの情報を元に証交付回収テーブル(URのテーブル)から情報を取得し、取得した情報を共有子Divに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param サブ業務コード サブ業務コード
     */
    void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード, SubGyomuCode サブ業務コード);

    /**
     * 入力明細エリアの情報をクリアします。
     */
    void clearInputData();

    /**
     * 証回収記録管理Divに設定されている、証交付回収履歴の情報を取得します。
     *
     * @return 証交付回収履歴List
     */
    IItemList<ShoKofuKaishu> get証交付回収履歴();

    /**
     * 証回収記録管理Divに設定されている、証交付回収履歴の情報を取得します。
     *
     * @param 証交付回収履歴List 証交付回収履歴List
     */
    void set証交付回収履歴(IItemList<ShoKofuKaishu> 証交付回収履歴List);
}

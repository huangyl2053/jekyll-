/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者台帳情報を検索できるクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoFinder implements IHihokenshaDaichoFinder {

    private final HihokenshaDaichoFinderBase<DbT1001HihokenshaDaichoEntity> finder;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoFinder() {
        finder = new HihokenshaDaichoFinderBase<>();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac
     * @param finder
     */
    HihokenshaDaichoFinder(HihokenshaDaichoFinderBase finder) {
        this.finder = finder;
    }

    @Override
    public IItemList<DbT1001HihokenshaDaichoEntity> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        return finder.find被保険者台帳List(市町村コード, 被保険者番号);
    }

    @Override
    public Optional<DbT1001HihokenshaDaichoEntity> find直近被保険者台帳(HihokenshaNo 被保険者番号) {
        return finder.find最新被保険者台帳(被保険者番号);
    }

    @Override
    public IItemList<DbT1001HihokenshaDaichoEntity> find直近被保険者台帳一覧(LasdecCode 市町村コード) {
        return finder.find被保険者台帳List(市町村コード);
    }

    @Override
    public Optional<DbT1001HihokenshaDaichoEntity> find被保険者台帳(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, YMDHMS 処理日時) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemList<DbT1001HihokenshaDaichoEntity> find被保険者台帳List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemList<DbT1001HihokenshaDaichoEntity> find被保険者台帳List(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, FlexibleDate 資格取得日) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

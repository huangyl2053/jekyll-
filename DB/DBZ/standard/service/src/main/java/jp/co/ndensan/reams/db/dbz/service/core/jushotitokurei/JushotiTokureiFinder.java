/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.jushotitokurei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.jushotitokure.JushotiTokureiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所地特例一覧データ取得するクラスです。
 *
 * @reamsid_L DBA-0150-010 zhangzhiming
 */
public class JushotiTokureiFinder {

    private final DbT1001HihokenshaDaichoDac dbT1001HihokenshaDaichoDac;

    /**
     * コンストラクタ。
     *
     */
    public JushotiTokureiFinder() {

        this.dbT1001HihokenshaDaichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT1001HihokenshaDaichoDac DbT1001HihokenshaDaichoDac
     */
    JushotiTokureiFinder(DbT1001HihokenshaDaichoDac dbT1001HihokenshaDaichoDac) {
        this.dbT1001HihokenshaDaichoDac = dbT1001HihokenshaDaichoDac;
    }

    /**
     * 住所地特例一覧データ取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     * @return SearchResult<JushotiTokureiBusiness> 住所地特例一覧
     */
    @Transaction
    public SearchResult<JushotiTokureiBusiness> getJushotiTokureiJoho(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        List<DbT1001HihokenshaDaichoEntity> jushotiTokurei;
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            jushotiTokurei = dbT1001HihokenshaDaichoDac.selectListHihokenshaNo(被保険者番号, 取得日);
        } else {
            jushotiTokurei = dbT1001HihokenshaDaichoDac.selectListShikibetsuCode(識別コード, 取得日);
        }
        if (jushotiTokurei == null || jushotiTokurei.isEmpty()) {
            return SearchResult.of(Collections.<JushotiTokureiBusiness>emptyList(), 0, false);
        }
        return get住所地特例リスト(jushotiTokurei);
    }

    private SearchResult<JushotiTokureiBusiness> get住所地特例リスト(List<DbT1001HihokenshaDaichoEntity> 住所地特例List) {
        List<JushotiTokureiBusiness> jushotiTokureiList = new ArrayList<>();
        Set<FlexibleDate> 住特適用日s = new HashSet<>();
        Set<FlexibleDate> 住特解除日s = new HashSet<>();
        for (DbT1001HihokenshaDaichoEntity entity : 住所地特例List) {
            FlexibleDate 住所地特例解除日 = entity.getJushochitokureiKaijoYMD();
            if (住所地特例解除日 != null && !住所地特例解除日.isEmpty() && !住特解除日s.contains(住所地特例解除日)) {
                entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
                entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
                entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
                jushotiTokureiList.add(new JushotiTokureiBusiness(entity));
                住特解除日s.add(住所地特例解除日);
                continue;
            }
            FlexibleDate 住所地特例適用日 = entity.getJushochitokureiTekiyoYMD();
            if (住所地特例適用日 != null && !住特適用日s.contains(住所地特例適用日)) {
                jushotiTokureiList.add(new JushotiTokureiBusiness(entity));
                住特適用日s.add(住所地特例適用日);
            }
        }
        return SearchResult.of(jushotiTokureiList, 0, false);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jushotitokurei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.jushotitokure.JushotiTokureiBusiness;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳マスタを管理するクラスです。
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
     * 住所地特例一覧データ取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     * @return List<DbT1001HihokenshaDaichoEntity> 住所地特例一覧
     */
    public List<JushotiTokureiBusiness> getJushotiTokureiJoho(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        List<DbT1001HihokenshaDaichoEntity> jushotiTokurei = new ArrayList<>();
        if (!被保険者番号.isEmpty()) {
            jushotiTokurei = dbT1001HihokenshaDaichoDac.selectListHihokenshaNo(被保険者番号, 取得日);
        } else if (被保険者番号.isEmpty()) {
            jushotiTokurei = dbT1001HihokenshaDaichoDac.selectListShikibetsuCode(識別コード, 取得日);
        }
        if (jushotiTokurei == null || jushotiTokurei.isEmpty()) {
            return new ArrayList<>();
        }
        return save住所地特例リスト(jushotiTokurei);
    }

    private List<JushotiTokureiBusiness> save住所地特例リスト(List<DbT1001HihokenshaDaichoEntity> 住所地特例List) {
        List<JushotiTokureiBusiness> jushotiTokureiList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : 住所地特例List) {
            if (entity.getJushochitokureiKaijoYMD() != null) {
                entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
                entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
                entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
            }
            jushotiTokureiList.add(new JushotiTokureiBusiness(entity));
        }
        return jushotiTokureiList;
    }
}

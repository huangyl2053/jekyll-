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
     * {@link InstanceProvider#create}にて生成した{@link JushotiTokureiFinder}のインスタンスを返します。
     *
     * @return JushotiTokureiFinder
     */
    public static JushotiTokureiFinder createInstance() {
        return InstanceProvider.create(JushotiTokureiFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
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
     * @return List<DbT1001HihokenshaDaichoEntity> 住所地特例一覧
     */
    public List<JushotiTokureiBusiness> JushotiTokurei(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {

        List<DbT1001HihokenshaDaichoEntity> JushotiTokurei = new ArrayList<>();
        if (!被保険者番号.isEmpty()) {
            JushotiTokurei = dbT1001HihokenshaDaichoDac.selectListHihokenshaNo(被保険者番号, 取得日);
        } else if (被保険者番号.isEmpty()) {
            JushotiTokurei = dbT1001HihokenshaDaichoDac.selectListShikibetsuCode(識別コード, 取得日);
        }
        if (JushotiTokurei == null || JushotiTokurei.isEmpty()) {
            return new ArrayList<>();
        }
        return save住所地特例リスト(JushotiTokurei);
    }

    private List<JushotiTokureiBusiness> save住所地特例リスト(List<DbT1001HihokenshaDaichoEntity> 住所地特例List) {
        List<JushotiTokureiBusiness> JushotiTokureiList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : 住所地特例List) {
            if (entity.getJushochitokureiKaijoYMD() != null) {
                entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
                entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
            }
            JushotiTokureiList.add(new JushotiTokureiBusiness(entity));
        }
        return JushotiTokureiList;
    }
}

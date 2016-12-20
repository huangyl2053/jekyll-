/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.validation.CommonValidationMessage;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.db.dbz.service.core.saikinshorisha.SaikinShorishaService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 最近処理者共有子DivのHandlerクラスです。
 */
public class SaikinShorishaHandler {

    private final SaikinShorishaDiv div;

    public SaikinShorishaHandler(SaikinShorishaDiv div) {
        this.div = div;
    }

    /**
     * 最近処理者共有子Divを初期化します。
     */
    public void initialize() {
        List<DbT7501NinteiSaikinShorishaEntity> entities = new SaikinShorishaService().findTarget();
        List<KeyValueDataSource> items = new ArrayList<>();
        for (DbT7501NinteiSaikinShorishaEntity entity : entities) {
            items.add(new KeyValueDataSource(entity.getHihokenshaNo(), entity.getHihokenshaNo().concat("　").concat(entity.getHihokenshaName())));
        }
        div.getDdlSaikinShorisha().setDataSource(items);
    }

    /**
     * 選択時のバリデーション処理を行います。
     *
     * @return
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getDdlSaikinShorisha().getDataSource().isEmpty()) {
            pairs.add(new ValidationMessageControlPair(CommonValidationMessage.検索条件未指定, div.getDdlSaikinShorisha()));
        }
        return pairs;
    }

    /**
     * 最近処理者を更新します。
     */
    public void update(RString hihokenshaNo, RString hihokenshaName) {
        new SaikinShorishaService().update(hihokenshaNo, hihokenshaName);
    }

    /**
     * 現在選択されている被保険者番号を返します。
     *
     * @return
     */
    public RString getSelectedHihokenshaNo() {
        return div.getDdlSaikinShorisha().getSelectedKey();
    }

}

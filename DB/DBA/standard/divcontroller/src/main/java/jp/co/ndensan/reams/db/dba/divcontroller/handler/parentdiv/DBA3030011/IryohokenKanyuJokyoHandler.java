/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA3030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.iryohokenkanyujokyo.IryohokenKanyuJokyoBusiness;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA3030011.IryohokenKanyuJokyoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshashikakuteisei.IryoHokenJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療保険加入情報管理のHandlerクラスです。
 *
 * @reamsid_L DBA-1230-010 yaoyahui
 */
public class IryohokenKanyuJokyoHandler {

    private static final RString 状態_登録 = new RString("登録");
    private final IryohokenKanyuJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public IryohokenKanyuJokyoHandler(IryohokenKanyuJokyoDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @return IryohokenKanyuJokyoBusiness
     */
    public IryohokenKanyuJokyoBusiness onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getIryoHokenIchiran().getCcdIryoHokenRireki().initialize(状態_登録, 識別コード.value(), 被保険者番号);
        IryohokenKanyuJokyoBusiness joho = new IryohokenKanyuJokyoBusiness();
        joho.setIryoHokenJohoList(get初期化時の医療保険情報());
        return joho;
    }

    /**
     * 初期化時の医療保険情報
     *
     * @return oldList 初期化時の医療保険情報list
     */
    public List<IryoHokenJoho> get初期化時の医療保険情報() {
        List<IryoHokenJoho> oldList = new ArrayList<>();
        for (dgIryohokenIchiran_Row row : div.getIryoHokenIchiran().getCcdIryoHokenRireki().getDataGridList()) {
            IryoHokenJoho joho = new IryoHokenJoho();
            joho.set医療保険加入年月日(row.getKanyuDate().getValue());
            joho.set医療保険種別コード(row.getShubetsuCode());
            joho.set医療保険者名称(row.getHokenshaName());
            joho.set医療保険者番号(row.getHokenshaCode());
            joho.set医療保険脱退年月日(row.getDattaiDate().getValue());
            joho.set医療保険記号番号(row.getKigoNo());
            joho.set履歴番号(row.getRirekiNo().getValue().intValue());
            joho.set市町村コード(new LasdecCode(row.getShichosonCode()));
            joho.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
            oldList.add(joho);
        }
        return oldList;
    }
}

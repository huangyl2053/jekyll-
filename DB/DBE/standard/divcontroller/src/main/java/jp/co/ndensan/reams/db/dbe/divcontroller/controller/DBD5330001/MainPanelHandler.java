package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.MainPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果通知（主治医）画面でのバリデーションを管理するハンドラークラスです。
 *
 */
public class MainPanelHandler {

    public static final RString 更新モード = new RString("修正");
    public static final RString 追加モード = new RString("追加");
    public static final RString 削除モード = new RString("削除");
    public static final RString 通常 = new RString("通常");
    public static final RString 削除 = new RString("削除");
    public static final RString デフォルト検索条件 = new RString("yuuKo");
    public static final CodeShubetsu コード種別 = new CodeShubetsu("5001");
    public static final boolean 有効 = true;
    public static final boolean 全て = false;

    private final MainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MainPanel のクラスファイル
     */
    public MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }
    
    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     */
    public void 二次判定期間の前後順チェック() {
        if (div.getTxtNijiHanteiKikan().getToValue().isBefore(div.getTxtNijiHanteiKikan().getFromValue())) {
             throw new ApplicationException(UrErrorMessages.終了日が開始日以前.toString());
        }
    }
    
    
    
    
    
    
    
    
    
}

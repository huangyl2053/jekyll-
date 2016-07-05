/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5110001;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新未申請者把握リスト作成(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinShinseishaHaakuListMyBatisParameter implements IMyBatisParameter {

    private RString 印刷範囲指定;
    private RString 認定有効期間_終了月;
    private RString 認定有効期間_終了月_From;
    private RString 認定有効期間_終了月_To;
    private boolean is印刷範囲指定が未申請者全て;
    private boolean is印刷範囲指定が対象月まで;
    private boolean is印刷範囲指定が範囲指定;
    private final RString 未申請者全て = new RString("未申請者全て");
    private final RString 対象月まで = new RString("対象月まで");
    private final RString 範囲指定 = new RString("範囲指定");
    private RString 認定申請区分_申請時_コード;
    private RString 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 印刷範囲指定 印刷範囲指定
     * @param 認定有効期間_終了月 認定有効期間_終了月
     * @param 認定有効期間_終了月_From 認定有効期間_終了月_From
     * @param 認定有効期間_終了月_To 認定有効期間_終了月_To
     */
    public KoshinShinseishaHaakuListMyBatisParameter(RString 印刷範囲指定,
            RString 認定有効期間_終了月, RString 認定有効期間_終了月_From, RString 認定有効期間_終了月_To) {
        this.印刷範囲指定 = 印刷範囲指定;
        this.認定有効期間_終了月 = 認定有効期間_終了月;
        this.認定有効期間_終了月_From = 認定有効期間_終了月_From;
        this.認定有効期間_終了月_To = 認定有効期間_終了月_To;
        this.is印刷範囲指定が未申請者全て = 未申請者全て.equals(印刷範囲指定);
        this.is印刷範囲指定が対象月まで = 対象月まで.equals(印刷範囲指定);
        this.is印刷範囲指定が範囲指定 = 範囲指定.equals(印刷範囲指定);
        this.認定申請区分_申請時_コード = NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード();
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public KoshinShinseishaHaakuListMyBatisParameter(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

}

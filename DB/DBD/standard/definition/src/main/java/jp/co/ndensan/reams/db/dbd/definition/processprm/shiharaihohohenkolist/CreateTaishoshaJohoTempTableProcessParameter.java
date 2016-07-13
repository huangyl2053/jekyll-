/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リスト作成用のパラメータクラスです。
 *
 * @reamsid_L DBD-3630-010 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTaishoshaJohoTempTableProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 登録者選択;
    private RString 差止予告登録者の選択;
    private RString 差止登録者の選択;
    private RString 償還予告登録者の選択;
    private RString 償還決定登録者の選択;
    private RString 償還決定登録者_差止中あり者のみの選択;
    private RString 償還決定登録者_保険料控除あり者のみの選択;
    private Long 改頁出力順ID;
    private RString 帳票ID;
    private RString reamsLoginID;

    /**
     * コンストラクタ作成です。
     *
     * @param kijyunYMD 二次判定開始年月日
     * @param torokushaSel 二次判定終了年月日
     * @param sashitomeYokoku 未だ入力
     * @param sashitomeToroku 主治医情報
     * @param shokanYokoku 申請書管理番号
     * @param shokanKettei 初期再保険者番号
     * @param shokanKetteiSashitomeAriOnly 主治医情報
     * @param shokanKetteiKojoAriOnly1Go 申請書管理番号
     * @param shuturokuJyunID 初期再保険者番号
     * @param tyouhyoID 支所コード
     */
    public CreateTaishoshaJohoTempTableProcessParameter(FlexibleDate kijyunYMD,
            RString torokushaSel,
            RString sashitomeYokoku,
            RString sashitomeToroku,
            RString shokanYokoku,
            RString shokanKettei,
            RString shokanKetteiSashitomeAriOnly,
            RString shokanKetteiKojoAriOnly1Go,
            Long shuturokuJyunID,
            RString tyouhyoID) {
        this.基準日 = kijyunYMD;
        this.登録者選択 = torokushaSel;
        this.差止予告登録者の選択 = sashitomeYokoku;
        this.差止登録者の選択 = sashitomeToroku;
        this.償還予告登録者の選択 = shokanYokoku;
        this.償還決定登録者の選択 = shokanKettei;
        this.償還決定登録者_差止中あり者のみの選択 = shokanKetteiSashitomeAriOnly;
        this.償還決定登録者_保険料控除あり者のみの選択 = shokanKetteiKojoAriOnly1Go;
        this.改頁出力順ID = shuturokuJyunID;
        this.帳票ID = tyouhyoID;
    }
}

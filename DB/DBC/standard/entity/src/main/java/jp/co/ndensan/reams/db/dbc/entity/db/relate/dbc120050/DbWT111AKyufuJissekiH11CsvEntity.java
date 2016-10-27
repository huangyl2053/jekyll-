/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績H11一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111AKyufuJissekiH11CsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private KokanShikibetsuNo 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private NyuryokuShikibetsuNo 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 70, name = "証記載保険者番号")
    private HokenshaNo 証記載保険者番号;
    @CsvField(order = 80, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 90, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 100, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 110, name = "事業所番号")
    private JigyoshaNo 事業所番号;
    @CsvField(order = 120, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 130, name = "公費１_負担者番号")
    private RString 公費１_負担者番号;
    @CsvField(order = 140, name = "公費１_受給者番号")
    private RString 公費１_受給者番号;
    @CsvField(order = 150, name = "公費２_負担者番号")
    private RString 公費２_負担者番号;
    @CsvField(order = 160, name = "公費２_受給者番号")
    private RString 公費２_受給者番号;
    @CsvField(order = 170, name = "公費３_負担者番号")
    private RString 公費３_負担者番号;
    @CsvField(order = 180, name = "公費３_受給者番号")
    private RString 公費３_受給者番号;
    @CsvField(order = 190, name = "生年月日")
    private FlexibleDate 生年月日;
    @CsvField(order = 200, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 210, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 220, name = "旧措置入所者特例コード")
    private RString 旧措置入所者特例コード;
    @CsvField(order = 230, name = "認定有効期間_開始年月日")
    private FlexibleDate 認定有効期間_開始年月日;
    @CsvField(order = 240, name = "認定有功期間_終了年月日")
    private FlexibleDate 認定有功期間_終了年月日;
    @CsvField(order = 250, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 260, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 270, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 280, name = "事業所番号_居宅介護支援事業所等")
    private JigyoshaNo 事業所番号_居宅介護支援事業所等;
    @CsvField(order = 290, name = "開始年月日")
    private FlexibleDate 開始年月日;
    @CsvField(order = 300, name = "中止年月日")
    private FlexibleDate 中止年月日;
    @CsvField(order = 310, name = "中止理由_入所院前の状況コード")
    private RString 中止理由_入所院前の状況コード;
    @CsvField(order = 320, name = "入所年月日")
    private FlexibleDate 入所年月日;
    @CsvField(order = 330, name = "退所年月日")
    private FlexibleDate 退所年月日;
    @CsvField(order = 340, name = "入所実日数")
    private int 入所実日数;
    @CsvField(order = 350, name = "外泊日数")
    private int 外泊日数;
    @CsvField(order = 360, name = "退所後の状態コード")
    private RString 退所後の状態コード;
    @CsvField(order = 370, name = "保険給付率")
    private HokenKyufuRitsu 保険給付率;
    @CsvField(order = 380, name = "公費１給付率")
    private HokenKyufuRitsu 公費１給付率;
    @CsvField(order = 390, name = "公費２給付率")
    private HokenKyufuRitsu 公費２給付率;
    @CsvField(order = 400, name = "公費３給付率")
    private HokenKyufuRitsu 公費３給付率;
    @CsvField(order = 410, name = "前_保険_サービス単位数")
    private int 前_保険_サービス単位数;
    @CsvField(order = 420, name = "前_保険_請求額")
    private Decimal 前_保険_請求額;
    @CsvField(order = 430, name = "前_保険_利用者負担額")
    private int 前_保険_利用者負担額;
    @CsvField(order = 440, name = "前_保険_緊急時施設療養費請求額")
    private Decimal 前_保険_緊急時施設療養費請求額;
    @CsvField(order = 450, name = "前_保険_特定診療費請求額")
    private Decimal 前_保険_特定診療費請求額;
    @CsvField(order = 460, name = "前_保険_特定入所者介護サービス費等請求額")
    private Decimal 前_保険_特定入所者介護サービス費等請求額;
    @CsvField(order = 470, name = "前_公費１_サービス単位数")
    private int 前_公費１_サービス単位数;
    @CsvField(order = 480, name = "前_公費１_請求額")
    private int 前_公費１_請求額;
    @CsvField(order = 490, name = "前_公費１_本人負担額")
    private int 前_公費１_本人負担額;
    @CsvField(order = 500, name = "前_公費１_緊急時施設療養費請求額")
    private int 前_公費１_緊急時施設療養費請求額;
    @CsvField(order = 510, name = "前_公費１_特定診療費請求額")
    private int 前_公費１_特定診療費請求額;
    @CsvField(order = 520, name = "前_公費１_特定入所者介護サービス費等請求額")
    private int 前_公費１_特定入所者介護サービス費等請求額;
    @CsvField(order = 530, name = "前_公費２_サービス単位数")
    private int 前_公費２_サービス単位数;
    @CsvField(order = 540, name = "前_公費２_請求額")
    private int 前_公費２_請求額;
    @CsvField(order = 550, name = "前_公費２_本人負担額")
    private int 前_公費２_本人負担額;
    @CsvField(order = 560, name = "前_公費２_緊急時施設療養費請求額")
    private int 前_公費２_緊急時施設療養費請求額;
    @CsvField(order = 570, name = "前_公費２_特定診療費請求額")
    private int 前_公費２_特定診療費請求額;
    @CsvField(order = 580, name = "前_公費２_特定入所者介護サービス費等請求額")
    private int 前_公費２_特定入所者介護サービス費等請求額;
    @CsvField(order = 590, name = "前_公費３_サービス単位数")
    private int 前_公費３_サービス単位数;
    @CsvField(order = 600, name = "前_公費３_請求額")
    private int 前_公費３_請求額;
    @CsvField(order = 610, name = "前_公費３_本人負担額")
    private int 前_公費３_本人負担額;
    @CsvField(order = 620, name = "前_公費３_緊急時施設療養費請求額")
    private int 前_公費３_緊急時施設療養費請求額;
    @CsvField(order = 630, name = "前_公費３_特定診療費請求額")
    private int 前_公費３_特定診療費請求額;
    @CsvField(order = 640, name = "前_公費３_特定入所者介護サービス費等請求額")
    private int 前_公費３_特定入所者介護サービス費等請求額;
    @CsvField(order = 650, name = "後_保険_サービス単位数")
    private int 後_保険_サービス単位数;
    @CsvField(order = 660, name = "後_保険_請求額")
    private Decimal 後_保険_請求額;
    @CsvField(order = 670, name = "後_保険_利用者負担額")
    private int 後_保険_利用者負担額;
    @CsvField(order = 680, name = "後_緊急時施設療養費請求額")
    private Decimal 後_緊急時施設療養費請求額;
    @CsvField(order = 690, name = "後_保険_特定診療費請求額")
    private Decimal 後_保険_特定診療費請求額;
    @CsvField(order = 700, name = "後_保険_特定入所者介護サービス費等請求額")
    private int 後_保険_特定入所者介護サービス費等請求額;
    @CsvField(order = 710, name = "後_公費１_サービス単位数")
    private int 後_公費１_サービス単位数;
    @CsvField(order = 720, name = "後_公費１_請求額")
    private int 後_公費１_請求額;
    @CsvField(order = 730, name = "後_公費１_本人負担額")
    private int 後_公費１_本人負担額;
    @CsvField(order = 740, name = "後_公費１_緊急時施設療養費請求額")
    private int 後_公費１_緊急時施設療養費請求額;
    @CsvField(order = 750, name = "後_公費１_特定診療費請求額")
    private int 後_公費１_特定診療費請求額;
    @CsvField(order = 760, name = "後_公費１_特定入所者介護サービス費等請求額")
    private int 後_公費１_特定入所者介護サービス費等請求額;
    @CsvField(order = 770, name = "後_公費２_サービス単位数")
    private int 後_公費２_サービス単位数;
    @CsvField(order = 780, name = "後_公費２_請求額")
    private int 後_公費２_請求額;
    @CsvField(order = 790, name = "後_公費２_本人負担額")
    private int 後_公費２_本人負担額;
    @CsvField(order = 800, name = "後_公費２_緊急時施設療養費請求額")
    private int 後_公費２_緊急時施設療養費請求額;
    @CsvField(order = 810, name = "後_公費２_特定診療費請求額")
    private int 後_公費２_特定診療費請求額;
    @CsvField(order = 820, name = "後_公費２_特定入所者介護サービス費等請求額")
    private int 後_公費２_特定入所者介護サービス費等請求額;
    @CsvField(order = 830, name = "後_公費３_サービス単位数")
    private int 後_公費３_サービス単位数;
    @CsvField(order = 840, name = "後_公費３_請求額")
    private int 後_公費３_請求額;
    @CsvField(order = 850, name = "後_公費３_本人負担額")
    private int 後_公費３_本人負担額;
    @CsvField(order = 860, name = "後_公費３_緊急時施設療養費請求額")
    private int 後_公費３_緊急時施設療養費請求額;
    @CsvField(order = 870, name = "後_公費３_特定診療費請求額")
    private int 後_公費３_特定診療費請求額;
    @CsvField(order = 880, name = "後_公費３_特定入所者介護サービス費等請求額")
    private int 後_公費３_特定入所者介護サービス費等請求額;
    @CsvField(order = 890, name = "警告区分コード")
    private RString 警告区分コード;
    @CsvField(order = 900, name = "審査年月")
    private FlexibleYearMonth 審査年月;
    @CsvField(order = 910, name = "ブランク")
    private RString ブランク;

}

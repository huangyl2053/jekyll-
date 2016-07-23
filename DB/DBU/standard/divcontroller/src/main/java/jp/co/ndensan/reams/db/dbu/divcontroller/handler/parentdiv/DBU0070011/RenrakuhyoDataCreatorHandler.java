/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0070011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.Hokenryo;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KaigoHokenRenrakuhyoHold;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KaigoHokenryoKisai;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KogakuKaigoServiceHiKisai;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KyojuhiFutanGendogakuKisai;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.KyufuGengakuKisai;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo.SyokuhiFutanGendogakuKisai;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutandankai.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator.FutangakuGengakuBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011.RenrakuhyoDataCreatorDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011.dgKaigoHokenryoGaitosha_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011.dgKaigoHokenryo_Row;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.business.core.view.JukyushaDaichoAlive;
import jp.co.ndensan.reams.db.dbz.definition.core.util.kogakukaigoservicehi.KogakuKaigoServiceHiJikoFutanJogenGaku;
import jp.co.ndensan.reams.db.dbz.definition.core.util.tokuteinyushosha.TokuteiNyushoshaFutanGendoNichigakuGetter;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険連絡票作成のハンドラークラスです。
 *
 * @reamsid_L DBA-1290-010 linghuhang
 */
public class RenrakuhyoDataCreatorHandler {

    private static final RString 給付額減額記載_無 = new RString("key0");
    private static final RString 給付額減額記載_有 = new RString("key1");
    private static final RString 食事の負担限度日額 = new RString("key0");
    private static final RString 段階区分 = new RString("0");
    private static final int INT_3 = 3;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final RString 黄色 = new RString("DBUFontcolor_yellow");
    private final RenrakuhyoDataCreatorDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険連絡票作成Div
     */
    public RenrakuhyoDataCreatorHandler(RenrakuhyoDataCreatorDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param 資格対象者キー 資格対象者キー
     * @param 支払方法変更 支払方法変更
     * @param 利用者負担額 利用者負担額
     * @param 負担限度額 負担限度額
     * @param 保険料段階情報 保険料段階情報
     * @param 算定基準額 算定基準額
     * @param is非該当 is非該当
     * @param 介護賦課 介護賦課
     * @param 基準日 基準日
     */
    public void onLoad(
            TaishoshaKey 資格対象者キー,
            ShiharaiHohoHenko 支払方法変更,
            Decimal 利用者負担額,
            FutangakuGengakuBusiness 負担限度額,
            List<HokenryoDankai> 保険料段階情報,
            Decimal 算定基準額,
            boolean is非該当,
            Fuka 介護賦課,
            FlexibleDate 基準日) {
        div.getCcdKaigoAtenaInfo().initialize(資格対象者キー.get識別コード());
        div.getCcdKaigoShikakuKihon().initialize(資格対象者キー.get識別コード());
        if (is非該当) {
            set非該当の項目設定(支払方法変更, 利用者負担額, 負担限度額, 保険料段階情報, 算定基準額, 介護賦課, is非該当, 基準日);
        } else {
            set該当の項目設定(支払方法変更, 利用者負担額, 負担限度額, 保険料段階情報, 算定基準額, 介護賦課, is非該当, 基準日);
        }
    }

    /**
     * 帳票の項目を設定します。
     *
     * @param 負担限度額 負担限度額
     * @param is非該当 is非該当
     * @param 受給者台帳 受給者台帳
     * @param 被保険者台帳 被保険者台帳
     * @param 基準日 基準日
     * @return KaigoHokenRenrakuhyoHold
     */
    public KaigoHokenRenrakuhyoHold set帳票の項目(FutangakuGengakuBusiness 負担限度額, boolean is非該当,
            JukyushaDaichoAlive 受給者台帳, HihokenshaDaichoAlive 被保険者台帳, FlexibleDate 基準日) {
        KaigoHokenRenrakuhyoHold 帳票の項目 = new KaigoHokenRenrakuhyoHold();
        KyufuGengakuKisai 給付減額 = new KyufuGengakuKisai();
        KyojuhiFutanGendogakuKisai 居住費の負担限度額 = new KyojuhiFutanGendogakuKisai();
        SyokuhiFutanGendogakuKisai 食費の_特定_負担限度額 = new SyokuhiFutanGendogakuKisai();
        KogakuKaigoServiceHiKisai 高額介護サービス費 = new KogakuKaigoServiceHiKisai();
        KaigoHokenryoKisai 介護保険料 = new KaigoHokenryoKisai();
        List<Hokenryo> 保険料段階一覧 = new ArrayList<>();
        IShikibetsuTaisho taisho = div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近();
        IKojin kojin = taisho.to個人();
        帳票の項目.set個人(kojin);
        帳票の項目.set連絡票作成日(基準日);
        if (負担限度額 == null) {
            居住費の負担限度額.set居住費の記載あり(false);
            食費の_特定_負担限度額.set食費の記載あり(false);
            帳票の項目.set旧措置者区分(new Code(new RString("0")));
            帳票の項目.set利用者負担段階(new Code(RiyoshaFutanDankai.第1段階.getコード()));
            食費の_特定_負担限度額.set対象者食費負担限度額(Decimal.ZERO);
        } else {
            食費の_特定_負担限度額.set食費の記載あり(true);
            居住費の負担限度額.set居住費の記載あり(true);
            帳票の項目.set旧措置者区分(new Code(負担限度額.get旧措置者区分()));
            帳票の項目.set利用者負担段階(new Code(負担限度額.get利用者負担段階()));
            食費の_特定_負担限度額.set対象者食費負担限度額(負担限度額.get食費負担限度額());
        }

        if (RString.isNullOrEmpty(div.getKaigoHokenryoSelected())) {
            介護保険料.set介護保険料の記載あり(false);
        } else {
            介護保険料.set介護保険料の記載あり(true);
            介護保険料.set対象者保険料段階区分(div.getDankaiKubunSelected());
        }
        if (is非該当) {
            for (dgKaigoHokenryo_Row row : div.getDgKaigoHokenryo().getDataSource()) {
                Hokenryo hokenryo = new Hokenryo();
                hokenryo.set段階区分(row.getDankaiKubun());
                hokenryo.set特例表記(row.getTokureiHyoki());
                hokenryo.set保険料額(row.getHokenryo().getValue());
                hokenryo.set保険料段階(row.getDankai());
                保険料段階一覧.add(hokenryo);
            }
        } else {
            for (dgKaigoHokenryoGaitosha_Row row : div.getDgKaigoHokenryoGaitosha().getDataSource()) {
                Hokenryo hokenryo = new Hokenryo();
                hokenryo.set段階区分(row.getDankaiKubun());
                hokenryo.set特例表記(row.getTokureiHyoki());
                hokenryo.set保険料額(row.getHokenryo().getValue());
                hokenryo.set保険料段階(row.getDankai());
                保険料段階一覧.add(hokenryo);
            }
        }
        介護保険料.set保険料段階一覧(保険料段階一覧);
        帳票の項目.set給付減額などの記載(給付減額);
        帳票の項目.set食費の_特定_負担限度額(食費の_特定_負担限度額);
        帳票の項目.set高額介護サービス費支給による自己負担限度額(高額介護サービス費);
        帳票の項目.set居住費の負担限度額(居住費の負担限度額);
        帳票の項目.set介護保険料(介護保険料);
        if (is非該当) {
            帳票の項目.set備考(div.getTxtRenrakuhyoBiko().getValue());
            set非該当帳票の項目(給付減額, 高額介護サービス費);
        } else {
            帳票の項目.set備考(div.getTxtRenrakuhyoBikoGaitosha().getValue());
            set該当帳票の項目(給付減額, 高額介護サービス費);
        }
        帳票の項目.set受給者台帳(受給者台帳);
        帳票の項目.set被保険者台帳(被保険者台帳);
        return 帳票の項目;
    }

    private void set非該当の項目設定(ShiharaiHohoHenko 支払方法変更, Decimal 利用者負担額, FutangakuGengakuBusiness 負担限度額,
            List<HokenryoDankai> 保険料段階情報, Decimal 算定基準額, Fuka 介護賦課, boolean is非該当, FlexibleDate 基準日) {
        TokuteiNyushoshaFutanGendoNichigakuGetter 特定入所者負担限度 = new TokuteiNyushoshaFutanGendoNichigakuGetter();
        Decimal 利用者負担金額 = new Decimal(0);
        if (利用者負担額 != null) {
            利用者負担金額 = 利用者負担額;
        }
        div.getTxtRenrakuhyoSakuseiDate().setValue(基準日);
        if (is給付額減額の記載有無(支払方法変更)) {
            div.getRadKyuhugakuGengakuUmu().setSelectedKey(給付額減額記載_有);
            div.getTxtKyufugakuGengaku().setValue(set金額フォマート(利用者負担金額));
        } else {
            div.getRadKyuhugakuGengakuUmu().setSelectedKey(給付額減額記載_無);
        }

        if (負担限度額 != null) {
            Code 旧措置者区分 = new Code(負担限度額.get旧措置者区分());
            RString 利用者負担段階 = 負担限度額.get利用者負担段階();
            Decimal 食費負担限度額 = 負担限度額.get食費負担限度額();
            if (RiyoshaFutanDankai.第1段階.getコード().equals(利用者負担段階)) {
                div.getTxtDaiichiKoshitsu().setDecorationClass(黄色);
                div.getTxtDaiichiJunKoshitsu().setDecorationClass(黄色);
                div.getTxtDaiichiTokuyo().setDecorationClass(黄色);
                div.getTxtDaiichiRokenRyoyogata().setDecorationClass(黄色);
                div.getTxtDaiichiTashoshitsu().setDecorationClass(黄色);
            } else if (RiyoshaFutanDankai.第2段階.getコード().equals(利用者負担段階)) {
                div.getTxtDainiKoshitsu().setDecorationClass(黄色);
                div.getTxtDainiJunKoshitsu().setDecorationClass(黄色);
                div.getTxtDainiTokuyo().setDecorationClass(黄色);
                div.getTxtDainiRokenRyoyogata().setDecorationClass(黄色);
                div.getTxtDainiTashoshitsu().setDecorationClass(黄色);
            } else if (RiyoshaFutanDankai.第3段階.getコード().equals(利用者負担段階)) {
                div.getTxtDaisanKoshitsu().setDecorationClass(黄色);
                div.getTxtDaisanJunKoshitsu().setDecorationClass(黄色);
                div.getTxtDaisanTokuyo().setDecorationClass(黄色);
                div.getTxtDaisanRokenRyoyogata().setDecorationClass(黄色);
                div.getTxtDaisanTashoshitsu().setDecorationClass(黄色);
            } else if (RiyoshaFutanDankai.課税層第3段階.getコード().equals(利用者負担段階)) {
                div.getTxtKijunHiyogakuKoshitsu().setDecorationClass(黄色);
                div.getTxtKijunHiyogakuJunKoshitsu().setDecorationClass(黄色);
                div.getTxtKijunHiyogakuTokuyo().setDecorationClass(黄色);
                div.getTxtKijunHiyogakuRokenRyoyogata().setDecorationClass(黄色);
                div.getTxtKijunHiyogakuTashoshitsu().setDecorationClass(黄色);
            }
            div.getTxtDaiichiKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型個室１(基準日, 旧措置者区分))));
            div.getTxtDaiichiJunKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型準個室１(基準日, 旧措置者区分))));
            div.getTxtDaiichiTokuyo().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個特養１(基準日, 旧措置者区分))));
            div.getTxtDaiichiRokenRyoyogata().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個老健１(基準日))));
            div.getTxtDaiichiTashoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get多床室１(基準日, 旧措置者区分))));

            div.getTxtDainiKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型個室２(基準日, 旧措置者区分))));
            div.getTxtDainiJunKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型準個室２(基準日, 旧措置者区分))));
            div.getTxtDainiTokuyo().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個特養２(基準日, 旧措置者区分))));
            div.getTxtDainiRokenRyoyogata().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個老健２(基準日))));
            div.getTxtDainiTashoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get多床室２(基準日, 旧措置者区分))));

            div.getTxtDaisanKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型個室３(基準日, 旧措置者区分))));
            div.getTxtDaisanJunKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型準個室３(基準日, 旧措置者区分))));
            div.getTxtDaisanTokuyo().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個特養３(基準日, 旧措置者区分))));
            div.getTxtDaisanRokenRyoyogata().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個老健３(基準日))));
            div.getTxtDaisanTashoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get多床室３(基準日, 旧措置者区分))));

            div.getTxtKijunHiyogakuKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型個室_基準費用額(基準日))));
            div.getTxtKijunHiyogakuJunKoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型準個室_基準費用額(基準日))));
            div.getTxtKijunHiyogakuTokuyo().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個特養_基準費用額(基準日))));
            div.getTxtKijunHiyogakuRokenRyoyogata().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個老健_基準費用額(基準日))));
            div.getTxtKijunHiyogakuTashoshitsu().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get多床室_基準費用額(基準日))));
            set非該当食事の負担限度(基準日, 旧措置者区分, 特定入所者負担限度);

            if (食費負担限度額 != null) {
                利用者負担金額 = 食費負担限度額;
            }
            set非該当食事の負担限度日額(利用者負担金額);
        }

        set保険料段階(保険料段階情報, 介護賦課, is非該当);
        set非該当高額介護サービス費(基準日);
        set非該当高額介護サービス費額(算定基準額);
    }

    private void set該当の項目設定(ShiharaiHohoHenko 支払方法変更, Decimal 利用者負担額, FutangakuGengakuBusiness 負担限度額,
            List<HokenryoDankai> 保険料段階情報, Decimal 算定基準額, Fuka 介護賦課, boolean is非該当, FlexibleDate 基準日) {
        TokuteiNyushoshaFutanGendoNichigakuGetter 特定入所者負担限度 = new TokuteiNyushoshaFutanGendoNichigakuGetter();
        Decimal 利用者負担金額 = new Decimal(0);
        if (利用者負担額 != null) {
            利用者負担金額 = 利用者負担額;
        }
        div.getTxtRenrakuhyoSakuseiDateGaitosha().setValue(基準日);
        if (is給付額減額の記載有無(支払方法変更)) {
            div.getRadKyuhugakuGengakuUmuGaitosha().setSelectedKey(給付額減額記載_有);
            div.getTxtKyufugakuGengakuGaitosha().setValue(set金額フォマート(利用者負担金額));
        } else {
            div.getRadKyuhugakuGengakuUmuGaitosha().setSelectedKey(給付額減額記載_無);
        }

        if (負担限度額 != null) {
            Code 旧措置者区分 = new Code(負担限度額.get旧措置者区分());
            RString 利用者負担段階 = 負担限度額.get利用者負担段階();
            Decimal 食費負担限度額 = 負担限度額.get食費負担限度額();

            div.getTxtDaiichiKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型個室１(基準日))));
            div.getTxtDaiichiJunKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室１(基準日))));
            div.getTxtDaiichiTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減従個特養１(基準日))));
            div.getTxtDaiichiTashoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減多床室１(基準日))));

            div.getTxtDainiKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型個室２(基準日))));
            div.getTxtDaininoIchiJunKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室２の１(基準日))));
            div.getTxtDaininoIchiTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減従個特養２の１(基準日))));
            div.getTxtDaininoIchiTashoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減多床室２の１(基準日))));

            div.getTxtDaisanKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型個室３(基準日))));
            div.getTxtDaininoNiJunKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室２の２(基準日))));
            div.getTxtDaininoNiTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減従個特養２の２(基準日))));
            div.getTxtDaininoNiTashoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減多床室２の２(基準日))));

            div.getTxtKijunHiyogakuKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型個室_基準費用額(基準日))));
            div.getTxtDaisanJunKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室３(基準日))));
            div.getTxtDaininoSanTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減従個特養２の３(基準日))));
            div.getTxtDaisanTashoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減多床室３(基準日))));

            div.getTxtKijunHiyogakuJunKoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.getユニット型準個室_基準費用額(基準日))));
            div.getTxtDaisanTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get旧措軽減従個特養３(基準日))));
            div.getTxtKijunHiyogakuTashoshitsuGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get多床室_基準費用額(基準日))));
            div.getTxtKijunHiyogakuTokuyoGaitosha().setValue(set金額フォマート(toDecimal(特定入所者負担限度.get従個特養_基準費用額(基準日))));
            set該当黄色(利用者負担段階, 特定入所者負担限度, 基準日, 負担限度額);
            set該当食事の負担限度(基準日, 特定入所者負担限度);
            if (食費負担限度額 != null) {
                利用者負担金額 = 食費負担限度額;
            }
            set該当食事の負担限度日額(利用者負担金額);
        }

        set保険料段階(保険料段階情報, 介護賦課, is非該当);
        set該当高額介護サービス費(基準日);
        set該当高額介護サービス費額(算定基準額);
    }

    private void set該当黄色(RString 利用者負担段階, TokuteiNyushoshaFutanGendoNichigakuGetter 特定入所者負担限度, FlexibleDate 基準日, FutangakuGengakuBusiness 負担限度額) {
        if (RiyoshaFutanDankai.第1段階.getコード().equals(利用者負担段階)) {
            div.getTxtDaiichiKoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtDaiichiJunKoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtDaiichiTokuyoGaitosha().setDecorationClass(黄色);
            div.getTxtDaiichiTashoshitsuGaitosha().setDecorationClass(黄色);
        } else if (RiyoshaFutanDankai.第2段階.getコード().equals(利用者負担段階)) {
            div.getTxtDainiKoshitsuGaitosha().setDecorationClass(黄色);
            if (toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室２の１(基準日)).equals(負担限度額.getユニット型準個室())) {
                div.getTxtDaininoIchiJunKoshitsuGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減従個特養２の１(基準日)).equals(負担限度額.get従来型個室_特養等())) {
                div.getTxtDaininoIchiTokuyoGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減多床室２の１(基準日)).equals(負担限度額.get多床室())) {
                div.getTxtDaininoIchiTashoshitsuGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減ユニット型準個室２の２(基準日)).equals(負担限度額.getユニット型準個室())) {
                div.getTxtDaininoNiJunKoshitsuGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減従個特養２の２(基準日)).equals(負担限度額.get従来型個室_特養等())) {
                div.getTxtDaininoNiTokuyoGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減多床室２の２(基準日)).equals(負担限度額.get多床室())) {
                div.getTxtDaininoNiTashoshitsuGaitosha().setDecorationClass(黄色);
            }
            if (toDecimal(特定入所者負担限度.get旧措軽減従個特養２の３(基準日)).equals(負担限度額.get従来型個室_特養等())) {
                div.getTxtDaininoSanTokuyoGaitosha().setDecorationClass(黄色);
            }
        } else if (RiyoshaFutanDankai.第3段階.getコード().equals(利用者負担段階)) {
            div.getTxtDaisanKoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtDaisanJunKoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtDaisanTashoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtDaisanTokuyoGaitosha().setDecorationClass(黄色);
        } else if (RiyoshaFutanDankai.課税層第3段階.getコード().equals(利用者負担段階)) {
            div.getTxtKijunHiyogakuJunKoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtKijunHiyogakuTashoshitsuGaitosha().setDecorationClass(黄色);
            div.getTxtKijunHiyogakuTokuyoGaitosha().setDecorationClass(黄色);
        }
        if (toDecimal(特定入所者負担限度.getユニット型個室_基準費用額(基準日)).equals(負担限度額.getユニット型個室())) {
            div.getTxtKijunHiyogakuKoshitsuGaitosha().setDecorationClass(黄色);
        }
    }

    private void set保険料段階(List<HokenryoDankai> 保険料段階情報, Fuka 介護賦課, boolean is非該当) {
        List<dgKaigoHokenryo_Row> rowList = new ArrayList<>();

        List<dgKaigoHokenryoGaitosha_Row> gaitoshaRowList = new ArrayList<>();
        if (is非該当) {
            for (HokenryoDankai 保険料段階 : 保険料段階情報) {
                dgKaigoHokenryo_Row row = new dgKaigoHokenryo_Row();
                row.setDankaiKubun(保険料段階.get段階区分());
                row.setDankai(保険料段階の編集(保険料段階.get段階区分()));
                if (!段階区分.equals(保険料段階.get段階区分().padZeroToLeft(INT_3).substring(INT_2, INT_3))) {
                    row.setTokureiHyoki(保険料段階.get特例表記());
                } else {
                    row.setTokureiHyoki(RString.EMPTY);
                }
                row.setDankaiAndTokurei(段階の編集(保険料段階の編集(保険料段階.get段階区分()), row.getTokureiHyoki()));
                row.getHokenryo().setValue(保険料段階.get保険料率());
                rowList.add(row);
            }
            div.getDgKaigoHokenryo().setDataSource(rowList);
        } else {
            for (HokenryoDankai 保険料段階 : 保険料段階情報) {
                dgKaigoHokenryoGaitosha_Row row = new dgKaigoHokenryoGaitosha_Row();
                row.setDankaiKubun(保険料段階.get段階区分());
                row.setDankai(保険料段階の編集(保険料段階.get段階区分()));
                if (!段階区分.equals(保険料段階.get段階区分().padZeroToLeft(INT_3).substring(INT_2, INT_3))) {
                    row.setTokureiHyoki(保険料段階.get特例表記());
                } else {
                    row.setTokureiHyoki(RString.EMPTY);
                }
                row.setDankaiAndTokurei(段階の編集(保険料段階の編集(保険料段階.get段階区分()), row.getTokureiHyoki()));
                row.getHokenryo().setValue(保険料段階.get保険料率());
                gaitoshaRowList.add(row);
            }
            div.getDgKaigoHokenryoGaitosha().setDataSource(gaitoshaRowList);
        }
        if (介護賦課 != null) {
            if (is非該当) {
                set非該当保険料段階選択(介護賦課, rowList);
            } else {
                set該当保険料段階選択(介護賦課, gaitoshaRowList);
            }
        }
    }

    private void set非該当保険料段階選択(Fuka 介護賦課, List<dgKaigoHokenryo_Row> rowList) {
        for (dgKaigoHokenryo_Row row : rowList) {
            if (介護賦課.get保険料段階().equals(row.getDankaiKubun())) {
                row.setSelected(Boolean.TRUE);
                div.setDankaiKubunSelected(row.getDankaiKubun());
                div.setKaigoHokenryoSelected(new RString("selected"));
            }
        }
    }

    private void set該当保険料段階選択(Fuka 介護賦課, List<dgKaigoHokenryoGaitosha_Row> gaitoshaRowList) {
        for (dgKaigoHokenryoGaitosha_Row row : gaitoshaRowList) {
            if (介護賦課.get保険料段階().equals(row.getDankaiKubun())) {
                row.setSelected(Boolean.TRUE);
                div.setDankaiKubunSelected(row.getDankaiKubun());
                div.setKaigoHokenryoSelected(new RString("selected"));
            }
        }
    }

    private void set非該当食事の負担限度(FlexibleDate 基準日, Code 旧措置者区分, TokuteiNyushoshaFutanGendoNichigakuGetter 特定入所者負担限度) {
        List<KeyValueDataSource> 負担限度日額 = new ArrayList<>();
        RString 負担限度金額_食費１ = 金額転換(特定入所者負担限度.get食費１(基準日, 旧措置者区分).split(","));
        RString 負担限度金額_食費２ = 金額転換(特定入所者負担限度.get食費２(基準日, 旧措置者区分).split(","));
        RString 負担限度金額_食費３ = 金額転換(特定入所者負担限度.get食費３(基準日, 旧措置者区分).split(","));
        RString 基準費用額_食費 = 金額転換(特定入所者負担限度.get食費_基準費用額(基準日).split(","));
        KeyValueDataSource 負担限度額_食費１ = new KeyValueDataSource();
        負担限度額_食費１.setKey(負担限度金額_食費１);
        負担限度額_食費１.setValue(set金額フォマート(toDecimal(負担限度金額_食費１)));
        KeyValueDataSource 負担限度額_食費２ = new KeyValueDataSource();
        負担限度額_食費２.setKey(負担限度金額_食費２);
        負担限度額_食費２.setValue(set金額フォマート(toDecimal(負担限度金額_食費２)));
        KeyValueDataSource 負担限度額_食費３ = new KeyValueDataSource();
        負担限度額_食費３.setKey(負担限度金額_食費３);
        負担限度額_食費３.setValue(set金額フォマート(toDecimal(負担限度金額_食費３)));
        KeyValueDataSource 食費_基準費用額 = new KeyValueDataSource();
        食費_基準費用額.setKey(基準費用額_食費);
        食費_基準費用額.setValue(set金額フォマート(toDecimal(基準費用額_食費)));
        負担限度日額.add(負担限度額_食費１);
        負担限度日額.add(負担限度額_食費２);
        負担限度日額.add(負担限度額_食費３);
        負担限度日額.add(食費_基準費用額);
        KeyValueDataSource dataSource = new KeyValueDataSource();
        dataSource.setKey(食事の負担限度日額);
        dataSource.setValue(RString.EMPTY);
        負担限度日額.add(dataSource);
        div.getRadShokuhiGaku().setDataSource(負担限度日額);
        div.getRadShokuhiGaku().setDataSource(負担限度日額);
    }

    private void set非該当食事の負担限度日額(Decimal 食費負担限度額) {
        List<KeyValueDataSource> 負担限度日額 = div.getRadShokuhiGaku().getDataSource();
        List<RString> 負担限度 = new ArrayList<>();
        for (KeyValueDataSource keyValue : 負担限度日額) {
            負担限度.add(keyValue.getValue());
        }
        if (負担限度.contains(set金額フォマート(食費負担限度額))) {
            div.getRadShokuhiGaku().setSelectedValue(set金額フォマート(食費負担限度額));
        } else {
            div.getRadShokuhiGaku().setSelectedKey(食事の負担限度日額);
            div.getTxtShokuhiGakuOther().setValue(set金額フォマート(食費負担限度額));
        }
    }

    private void set該当食事の負担限度(FlexibleDate 基準日, TokuteiNyushoshaFutanGendoNichigakuGetter 特定入所者負担限度) {
        List<KeyValueDataSource> 負担限度日額 = new ArrayList<>();
        RString 負担限度金額_食費１ = 金額転換(特定入所者負担限度.get旧措軽減食費１(基準日).split(","));
        RString 負担限度金額_食費２ = 金額転換(特定入所者負担限度.get旧措軽減食費２(基準日).split(","));
        RString 負担限度金額_食費３ = 金額転換(特定入所者負担限度.get旧措軽減食費３(基準日).split(","));
        RString 基準費用額_食費 = 金額転換(特定入所者負担限度.get食費_基準費用額(基準日).split(","));
        KeyValueDataSource 負担限度額_食費１ = new KeyValueDataSource();
        負担限度額_食費１.setKey(負担限度金額_食費１);
        負担限度額_食費１.setValue(set金額フォマート(toDecimal(負担限度金額_食費１)));
        KeyValueDataSource 負担限度額_食費２ = new KeyValueDataSource();
        負担限度額_食費２.setKey(負担限度金額_食費２);
        負担限度額_食費２.setValue(set金額フォマート(toDecimal(負担限度金額_食費２)));
        KeyValueDataSource 負担限度額_食費３ = new KeyValueDataSource();
        負担限度額_食費３.setKey(負担限度金額_食費３);
        負担限度額_食費３.setValue(set金額フォマート(toDecimal(負担限度金額_食費３)));
        KeyValueDataSource 食費_基準費用額 = new KeyValueDataSource();
        食費_基準費用額.setKey(基準費用額_食費);
        食費_基準費用額.setValue(set金額フォマート(toDecimal(基準費用額_食費)));
        負担限度日額.add(負担限度額_食費１);
        負担限度日額.add(負担限度額_食費２);
        負担限度日額.add(負担限度額_食費３);
        負担限度日額.add(食費_基準費用額);
        KeyValueDataSource dataSource = new KeyValueDataSource();
        dataSource.setKey(食事の負担限度日額);
        dataSource.setValue(RString.EMPTY);
        負担限度日額.add(dataSource);
        div.getRadShokuhiGakuGaitosha().setDataSource(負担限度日額);
    }

    private void set該当食事の負担限度日額(Decimal 食費負担限度額) {
        List<KeyValueDataSource> 負担限度日額 = div.getRadShokuhiGakuGaitosha().getDataSource();
        List<RString> 負担限度 = new ArrayList<>();
        for (KeyValueDataSource keyValue : 負担限度日額) {
            負担限度.add(keyValue.getValue());
        }
        if (負担限度.contains(set金額フォマート(食費負担限度額))) {
            div.getRadShokuhiGakuGaitosha().setSelectedValue(set金額フォマート(食費負担限度額));
        } else {
            div.getRadShokuhiGakuGaitosha().setSelectedKey(食事の負担限度日額);
            div.getTxtShokuhiGakuOtherGaitosha().setValue(set金額フォマート(食費負担限度額));
        }
    }

    private void set非該当高額介護サービス費(FlexibleDate 基準日) {
        KogakuKaigoServiceHiJikoFutanJogenGaku 高額介護 = new KogakuKaigoServiceHiJikoFutanJogenGaku();
        List<KeyValueDataSource> 高額介護サービス額 = new ArrayList<>();
        RString 高額介護サービス金額１ = 金額転換(高額介護.get第1段階(基準日).split(","));
        RString 高額介護サービス金額２ = 金額転換(高額介護.get第2段階(基準日).split(","));
        RString 高額介護サービス金額３ = 金額転換(高額介護.get第3段階(基準日).split(","));
        RString 高額介護サービス金額４ = 金額転換(高額介護.get第4段階(基準日).split(","));
        KeyValueDataSource 高額介護サービス額１ = new KeyValueDataSource();
        高額介護サービス額１.setKey(高額介護サービス金額１);
        高額介護サービス額１.setValue(set金額フォマート(toDecimal(高額介護サービス金額１)));
        KeyValueDataSource 高額介護サービス額２ = new KeyValueDataSource();
        高額介護サービス額２.setKey(高額介護サービス金額２);
        高額介護サービス額２.setValue(set金額フォマート(toDecimal(高額介護サービス金額２)));
        KeyValueDataSource 高額介護サービス額３ = new KeyValueDataSource();
        高額介護サービス額３.setKey(高額介護サービス金額３);
        高額介護サービス額３.setValue(set金額フォマート(toDecimal(高額介護サービス金額３)));
        KeyValueDataSource 高額介護サービス額４ = new KeyValueDataSource();
        高額介護サービス額４.setKey(高額介護サービス金額４);
        高額介護サービス額４.setValue(set金額フォマート(toDecimal(高額介護サービス金額４)));
        高額介護サービス額.add(高額介護サービス額１);
        高額介護サービス額.add(高額介護サービス額２);
        高額介護サービス額.add(高額介護サービス額３);
        高額介護サービス額.add(高額介護サービス額４);
        KeyValueDataSource dataSource = new KeyValueDataSource();
        dataSource.setKey(食事の負担限度日額);
        dataSource.setValue(RString.EMPTY);
        高額介護サービス額.add(dataSource);
        div.getRadKogakuKaigoServiceHi().setDataSource(高額介護サービス額);
    }

    private void set非該当高額介護サービス費額(Decimal 高額介護サービス費) {
        List<KeyValueDataSource> 高額介護サービス額 = div.getRadKogakuKaigoServiceHi().getDataSource();
        List<RString> 高額介護サービス = new ArrayList<>();
        for (KeyValueDataSource keyValue : 高額介護サービス額) {
            高額介護サービス.add(keyValue.getValue());
        }
        if (高額介護サービス.contains(set金額フォマート(高額介護サービス費))) {
            div.getRadKogakuKaigoServiceHi().setSelectedValue(set金額フォマート(高額介護サービス費));
        } else {
            div.getRadKogakuKaigoServiceHi().setSelectedKey(食事の負担限度日額);
            div.getTxtKogakuKaigoServiceHiOther().setValue(set金額フォマート(高額介護サービス費));
        }
    }

    private void set該当高額介護サービス費(FlexibleDate 基準日) {
        KogakuKaigoServiceHiJikoFutanJogenGaku 高額介護 = new KogakuKaigoServiceHiJikoFutanJogenGaku();
        List<KeyValueDataSource> 高額介護サービス額 = new ArrayList<>();
        RString 高額介護サービス金額１ = 金額転換(高額介護.get第1段階(基準日).split(","));
        RString 高額介護サービス金額２ = 金額転換(高額介護.get第2段階(基準日).split(","));
        RString 高額介護サービス金額３ = 金額転換(高額介護.get第3段階(基準日).split(","));
        RString 高額介護サービス金額４ = 金額転換(高額介護.get第4段階(基準日).split(","));
        KeyValueDataSource 高額介護サービス額１ = new KeyValueDataSource();
        高額介護サービス額１.setKey(高額介護サービス金額１);
        高額介護サービス額１.setValue(set金額フォマート(toDecimal(高額介護サービス金額１)));
        KeyValueDataSource 高額介護サービス額２ = new KeyValueDataSource();
        高額介護サービス額２.setKey(高額介護サービス金額２);
        高額介護サービス額２.setValue(set金額フォマート(toDecimal(高額介護サービス金額２)));
        KeyValueDataSource 高額介護サービス額３ = new KeyValueDataSource();
        高額介護サービス額３.setKey(高額介護サービス金額３);
        高額介護サービス額３.setValue(set金額フォマート(toDecimal(高額介護サービス金額３)));
        KeyValueDataSource 高額介護サービス額４ = new KeyValueDataSource();
        高額介護サービス額４.setKey(高額介護サービス金額４);
        高額介護サービス額４.setValue(set金額フォマート(toDecimal(高額介護サービス金額４)));

        高額介護サービス額.add(高額介護サービス額１);
        高額介護サービス額.add(高額介護サービス額２);
        高額介護サービス額.add(高額介護サービス額３);
        高額介護サービス額.add(高額介護サービス額４);
        KeyValueDataSource dataSource = new KeyValueDataSource();
        dataSource.setKey(食事の負担限度日額);
        dataSource.setValue(RString.EMPTY);
        高額介護サービス額.add(dataSource);
        div.getRadKogakuKaigoServiceHiGaitosha().setDataSource(高額介護サービス額);
    }

    private void set該当高額介護サービス費額(Decimal 高額介護サービス費) {
        List<KeyValueDataSource> 高額介護サービス額 = div.getRadKogakuKaigoServiceHiGaitosha().getDataSource();
        List<RString> 高額介護サービス = new ArrayList<>();
        for (KeyValueDataSource keyValue : 高額介護サービス額) {
            高額介護サービス.add(keyValue.getValue());
        }
        if (高額介護サービス.contains(set金額フォマート(高額介護サービス費))) {
            div.getRadKogakuKaigoServiceHiGaitosha().setSelectedValue(set金額フォマート(高額介護サービス費));
        } else {
            div.getRadKogakuKaigoServiceHiGaitosha().setSelectedKey(食事の負担限度日額);
            div.getTxtKogakuKaigoServiceHiOtherGaitosha().setValue(set金額フォマート(高額介護サービス費));
        }
    }

    private void set非該当帳票の項目(KyufuGengakuKisai 給付減額,
            KogakuKaigoServiceHiKisai 高額介護サービス費) {
        if (給付額減額記載_有.equals(div.getRadKyuhugakuGengakuUmu().getSelectedKey())) {
            給付減額.set給付減額等の記載あり(true);
            給付減額.set給付減額(toDecimal(div.getTxtKyufugakuGengaku().getValue()));
        } else {
            給付減額.set給付減額等の記載あり(false);
            給付減額.set給付減額(Decimal.ZERO);
        }

        高額介護サービス費.set高額介護サービス費の記載あり(true);
        if (RString.isNullOrEmpty(div.getTxtKogakuKaigoServiceHiOther().getValue())) {
            高額介護サービス費.set対象者自己負担額(toDecimal(div.getRadKogakuKaigoServiceHi().getSelectedValue()));
        } else {
            高額介護サービス費.set対象者自己負担額(toDecimal(div.getTxtKogakuKaigoServiceHiOther().getValue()));
        }
    }

    private void set該当帳票の項目(KyufuGengakuKisai 給付減額, KogakuKaigoServiceHiKisai 高額介護サービス費) {
        if (給付額減額記載_有.equals(div.getRadKyuhugakuGengakuUmuGaitosha().getSelectedKey())) {
            給付減額.set給付減額等の記載あり(true);
            給付減額.set給付減額(toDecimal(div.getTxtKyufugakuGengakuGaitosha().getValue()));
        } else {
            給付減額.set給付減額等の記載あり(false);
            給付減額.set給付減額(Decimal.ZERO);
        }
        高額介護サービス費.set高額介護サービス費の記載あり(true);
        if (RString.isNullOrEmpty(div.getTxtKogakuKaigoServiceHiOtherGaitosha().getValue())) {
            高額介護サービス費.set対象者自己負担額(toDecimal(div.getRadKogakuKaigoServiceHiGaitosha().getSelectedValue()));
        } else {
            高額介護サービス費.set対象者自己負担額(toDecimal(div.getTxtKogakuKaigoServiceHiOtherGaitosha().getValue()));
        }
    }

    private boolean is給付額減額の記載有無(ShiharaiHohoHenko 支払方法変更) {
        return 支払方法変更 != null;
    }

    private RString set金額フォマート(Decimal 利用者負担額) {
        return DecimalFormatter.toコンマ区切りRString(利用者負担額, 0);
    }

    private Decimal toDecimal(RString 金額) {
        if (!RString.isNullOrEmpty(金額)) {
            return new Decimal(金額転換(金額.split(",")).toString());
        }
        return Decimal.ZERO;
    }

    private RString 金額転換(List<RString> 金額) {
        RStringBuilder builder = new RStringBuilder();
        for (RString kinkaku : 金額) {
            builder.append(kinkaku);
        }
        return builder.toRString();
    }

    private RString 保険料段階の編集(RString 段階区分) {
        RStringBuilder builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(段階区分)) {
            return builder.append("第").append(段階区分.padZeroToLeft(INT_3).substring(INT_1, INT_2)).append("段階").toRString();
        }
        return RString.EMPTY;
    }

    private RString 段階の編集(RString 保険料段階, RString 特例表記) {
        RStringBuilder builder = new RStringBuilder();
        if (RString.isNullOrEmpty(特例表記)) {
            return 保険料段階;
        }
        return builder.append(保険料段階).append(特例表記).toRString();
    }
}

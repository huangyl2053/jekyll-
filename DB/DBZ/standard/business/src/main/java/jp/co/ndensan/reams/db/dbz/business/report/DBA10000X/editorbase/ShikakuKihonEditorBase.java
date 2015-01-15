/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoKanji;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.KannaiKangai;
import jp.co.ndensan.reams.ur.urz.model.IJusho;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Formatted;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Width;

/**
 * 被保険者証の被保険者資格基本情報について編集を行うEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuKihonEditorBase {

    private final HihokenshashoModel hihokenshashoModel;
    private final IZenkokuJushoItem zenkokuJusho;
    private final HihokenshashoPrintConfig printConfig;
    private final HihokenshashoJushoEditConfig hihoJushoEdit;
    private final ChohyoKyotsuJushoEditConfig kyotsuJushoEdit;

    private static final int GYOSEIKU_LENGTH;

    static {
        GYOSEIKU_LENGTH = 13;
    }

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoModel 被保険者証Model
     * @param zenkokuJusho 全国住所Item
     * @param printConfig 被保険者証表示方法コンフィグ
     * @param hihoJushoEdit 被保険者証住所編集コンフィグ
     * @param kyotsuJushoEdit 共通住所編集コンフィグ
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public ShikakuKihonEditorBase(HihokenshashoModel hihokenshashoModel, IZenkokuJushoItem zenkokuJusho, HihokenshashoPrintConfig printConfig,
            HihokenshashoJushoEditConfig hihoJushoEdit, ChohyoKyotsuJushoEditConfig kyotsuJushoEdit) throws NullPointerException {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));
        requireNonNull(zenkokuJusho, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("全国住所", getClass().getName()));

        requireNonNull(printConfig, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証表示方法コンフィグ", getClass().getName()));
        requireNonNull(hihoJushoEdit, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証住所編集", getClass().getName()));
        requireNonNull(kyotsuJushoEdit, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("共通住所編集", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
        this.zenkokuJusho = zenkokuJusho;
        this.printConfig = printConfig;
        this.hihoJushoEdit = hihoJushoEdit;
        this.kyotsuJushoEdit = kyotsuJushoEdit;
    }

    /**
     * 被保険者証帳票ソースに、被保険者番号の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set被保険者番号(IHihokenshashoCommonEditData source) {
        HihokenshaDaichoModel hihoDaicho = hihokenshashoModel.getHihokenshaDaicho();
        RString hihoNo = hihoDaicho.get被保険者番号().value();

        switch (printConfig.get被保険者番号表示書式()) {
            case 前ゼロをスペースに変換:
                source.setHihokenshanno(changeZeroToSpace(hihoNo));
                break;
            case そのまま:
                source.setHihokenshanno(hihoNo);
                break;
        }
    }

    private RString changeZeroToSpace(RString hihoNoString) {
        RStringBuilder builder = new RStringBuilder();
        for (int i = 0; i < hihoNoString.length(); i++) {
            RString hihoNoChar = hihoNoString.stringAt(i);
            if (hihoNoChar.equals(new RString("0"))) {
                builder.append(" ");
            } else {
                builder.append(hihoNoString.substring(i));
                break;
            }
        }
        return builder.toRString();
    }

    /**
     * 被保険者証帳票ソースに、住所・郵便番号・行政区などの情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set住所(IHihokenshashoCommonEditData source) {
        IKojin kojinJoho = hihokenshashoModel.getKojinJoho();
        IJusho jusho = kojinJoho.get住所();

        if (printConfig.is郵便番号表示有り()) {
            source.setYubinno(jusho.get郵便番号().getEditedYubinNo());
        }

        TodofukenNamePrint todofuken;
        GunNamePrint gunName;
        ShichosonNamePrint shichosonName;
        HowToEditJusho howToEditJusho;
        KatagakiPrint katagaki;
        if (hihoJushoEdit.uses帳票独自区分()) {
            todofuken = hihoJushoEdit.get都道府県名付与有無();
            gunName = hihoJushoEdit.get郡名付与有無();
            shichosonName = hihoJushoEdit.get市町村名付与有無();
            howToEditJusho = hihoJushoEdit.get住所編集方法();
            katagaki = hihoJushoEdit.get方書表示有無();
        } else {
            todofuken = kyotsuJushoEdit.get都道府県名付与有無();
            gunName = kyotsuJushoEdit.get郡名付与有無();
            shichosonName = kyotsuJushoEdit.get市町村名付与有無();
            howToEditJusho = kyotsuJushoEdit.get住所編集方法();
            katagaki = kyotsuJushoEdit.get方書表示有無();
        }

        //TODO n8178 全国住所を取得してきて処理するのは正しくない。対応方法を確認後に、住所の編集処理を修正する。
        if (jusho.get管内管外().equals(KannaiKangai.管内)) {
            setGyoseiku(source, jusho);

            RStringBuilder jushoBuilder = new RStringBuilder();
//            IZenkokuJushoKanji jushoKanji = zenkokuJusho.get全国住所漢字();
            if (todofuken == TodofukenNamePrint.印字する) {
//                jushoBuilder.append(jushoKanji.get都道府県名());
            }
            if (gunName == GunNamePrint.印字する) {
                //TODO n8178 城間篤人 全国住所Itemでは、群名を取得できない？ 取得方法を確認後に修正が必要。
                //jushoBuilder.append(jushoKanji.get市町村名());
            }
            if (shichosonName == ShichosonNamePrint.印字する) {
//                jushoBuilder.append(jushoKanji.get市町村名());
            }
            switch (howToEditJusho) {
                case 住所と番地:
                case 住所と番地_行政区:
//                    jushoBuilder.append(jusho.get住所());
//                    jushoBuilder.append(jusho.get番地().getBanchi().getColumnValue());
                    break;
                case 行政区と番地:
//                    jushoBuilder.append(jusho.get行政区());
//                    jushoBuilder.append(jusho.get番地().getBanchi().getColumnValue());
                    break;

                case 番地のみ:
//                    jushoBuilder.append(jusho.get番地().getBanchi().getColumnValue());
                    break;
                case 印字しない:
                default:
                    break;
            }

            if (katagaki == KatagakiPrint.印字する) {
//                jushoBuilder.append(RString.HALF_SPACE);
//                jushoBuilder.append(jusho.get方書().value());
            }

            source.setHihojusho(jushoBuilder.toRString());
        } else {
            source.setHihojusho(jusho.get住所());
        }
    }

    private void setGyoseiku(IHihokenshashoCommonEditData source, IJusho jusho) {
        if (jusho.get行政区().length() <= GYOSEIKU_LENGTH) {
            source.setGyoseiku(jusho.get行政区());
        } else {
            source.setGyoseikuS(jusho.get行政区());
        }
    }

    /**
     * 被保険者証帳票ソースに、被保険者名称の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set被保険者名(IHihokenshashoCommonEditData source) {
        IKojin kojin = hihokenshashoModel.getKojinJoho();
        source.setHihoname(kojin.get氏名().getName().value());
        if (printConfig.is氏名カナ表示有り()) {
            source.setHihokana(kojin.get氏名().getKana().value());
        } else {
            source.setHihokana(RString.EMPTY);
        }
    }

    /**
     * 被保険者証帳票ソースに、交付日の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set交付日(IHihokenshashoCommonEditData source) {
        FlexibleDate kofuDate = hihokenshashoModel.getShikakuHakko().get交付日();
        Formatted formattedKofuDate = kofuDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).width(Width.HALF);
        source.setKofuymdGengo(formattedKofuDate.getEra());
        source.setKofuymdYy(formattedKofuDate.getYear().replace(formattedKofuDate.getEra(), RString.EMPTY));
        source.setKofuymdMm(formattedKofuDate.getMonth());
        source.setKofuymdDd(formattedKofuDate.getDay());
    }

    /**
     * 被保険者証帳票ソースに、再交付の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set再交付情報(IHihokenshashoCommonEditData source) {
        //TODO n8178 城間 DBAのコードマスタに対応するEnumを、後でkyotsu-productにて作成する。 2015年1月末
        if (hihokenshashoModel.getShikakuHakko().get交付事由コード().equals(new RString("90"))) {
            source.setSaikofu1(new RString("再交付"));
            source.setSaikofu2(new RString("再交付"));
        }
    }

    /**
     * 被保険者証帳票ソースに、保険者番号の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set保険者番号(IHihokenshashoCommonEditData source) {
        RString HokenshaNo = hihokenshashoModel.getShikakuHakko().get保険者番号();
        source.setHokenshano1(HokenshaNo.stringAt(0));
        source.setHokenshano2(HokenshaNo.stringAt(1));
        source.setHokenshano3(HokenshaNo.stringAt(2));
        source.setHokenshano4(HokenshaNo.stringAt(3));
        source.setHokenshano5(HokenshaNo.stringAt(4));
        source.setHokenshano6(HokenshaNo.stringAt(5));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.ChosaKekkaInfoKihonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.TokiJikouBusiness;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser23;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser24;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser30;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser31;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser32;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果情報照会_基本調査の取得するクラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class ChosaKekkaInfoKihonHandler {

    private enum AnswerPattern {

        /**
         * 回答パターン1, 回答パターンコード: "1"。
         */
        回答パターン1(new RString("1")),
        /**
         * 回答パターン2, 回答パターンコード: "2"。
         */
        回答パターン2(new RString("2")),
        /**
         * 回答パターン3, 回答パターンコード: "3"。
         */
        回答パターン3(new RString("3")),
        /**
         * 回答パターン4, 回答パターンコード: "4"。
         */
        回答パターン4(new RString("4")),
        /**
         * 回答パターン5, 回答パターンコード: "5"。
         */
        回答パターン5(new RString("5")),
        /**
         * 回答パターン6, 回答パターンコード: "6"。
         */
        回答パターン6(new RString("6")),
        /**
         * 回答パターン7, 回答パターンコード: "7"。
         */
        回答パターン7(new RString("7")),
        /**
         * 回答パターン8, 回答パターンコード: "8"。
         */
        回答パターン8(new RString("8")),
        /**
         * 回答パターン9, 回答パターンコード: "9"。
         */
        回答パターン9(new RString("9")),
        /**
         * 回答パターン10, 回答パターンコード: "10"。
         */
        回答パターン10(new RString("10")),
        /**
         * 回答パターン11, 回答パターンコード: "11"。
         */
        回答パターン11(new RString("11")),
        /**
         * 回答パターン12, 回答パターンコード: "12"。
         */
        回答パターン12(new RString("12")),
        /**
         * 回答パターン13, 回答パターンコード: "13"。
         */
        回答パターン13(new RString("13")),
        /**
         * 回答パターン14, 回答パターンコード: "14"。
         */
        回答パターン14(new RString("14")),
        /**
         * 回答パターン15, 回答パターンコード: "15"。
         */
        回答パターン15(new RString("15")),
        /**
         * 回答パターン16, 回答パターンコード: "16"。
         */
        回答パターン16(new RString("16")),
        /**
         * 回答パターン17, 回答パターンコード: "17"。
         */
        回答パターン17(new RString("17")),
        /**
         * 回答パターン20, 回答パターンコード: "20"。
         */
        回答パターン20(new RString("20")),
        /**
         * 回答パターン21, 回答パターンコード: "21"。
         */
        回答パターン21(new RString("21")),
        /**
         * 回答パターン22, 回答パターンコード: "22"。
         */
        回答パターン22(new RString("22")),
        /**
         * 回答パターン23, 回答パターンコード: "23"。
         */
        回答パターン23(new RString("23")),
        /**
         * 回答パターン24, 回答パターンコード: "24"。
         */
        回答パターン24(new RString("24")),
        /**
         * 回答パターン30, 回答パターンコード: "30"。
         */
        回答パターン30(new RString("30")),
        /**
         * 回答パターン31, 回答パターンコード: "31"。
         */
        回答パターン31(new RString("31")),
        /**
         * 回答パターン32, 回答パターンコード: "32"。
         */
        回答パターン32(new RString("32")),
        /**
         * 回答パターン33, 回答パターンコード: "33"。
         */
        回答パターン33(new RString("33")),
        /**
         * 回答パターン34, 回答パターンコード: "34"。
         */
        回答パターン34(new RString("34"));

        private final RString answerPatternCode;

        private AnswerPattern(RString answerPatternCode) {
            this.answerPatternCode = answerPatternCode;
        }

        /**
         * ファイル名称を返します。
         *
         * @return コード
         */
        public RString getコード() {
            return this.answerPatternCode;
        }

        /**
         * 回答パターンのコードと一致する内容を探します。
         *
         * @param code 回答パターンのコード
         * @return {@code code} に対応する回答パターン
         */
        public static AnswerPattern toValue(RString code) {
            for (AnswerPattern answerPattern : AnswerPattern.values()) {
                if (answerPattern.answerPatternCode.equals(code)) {
                    return answerPattern;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("回答パターン"));
        }
    }

    private final ChosaKekkaInfoKihonDiv kihonDiv;
    private static final RString IMAGEFILENAME_認定調査実施場所 = new RString("C0001.png");

    /**
     * コンストラクタです。
     *
     * @param kihonDiv ChosaKekkaInfoKihonDiv
     */
    public ChosaKekkaInfoKihonHandler(ChosaKekkaInfoKihonDiv kihonDiv) {
        this.kihonDiv = kihonDiv;
    }

    /**
     * onLoad処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param chosaKekkaInfoGaikyoList ChosaKekkaInfoKihonBusiness
     * @param serviceJokyos TokiJikouBusiness
     */
    public void onLoad(RString 申請書管理番号,
            List<ChosaKekkaInfoKihonBusiness> chosaKekkaInfoGaikyoList, List<TokiJikouBusiness> serviceJokyos) {
//        kihonDiv.getTxtNinteichosaJisshiYMD().setDisabled(true);
//        kihonDiv.getTxtChosaJisshiBashoMeisho().setDisabled(true);
        kihonDiv.getTxtNinteichosaJisshiYMD().setDisplayNone(true);
        kihonDiv.getTxtChosaJisshiBashoMeisho().setDisplayNone(true);
        kihonDiv.getLblJisshiBasho().setDisplayNone(true);
        kihonDiv.getJisshiBashoMeishoPanel().setDisplayNone(true);
        kihonDiv.getKihonChosaPanel().getTxtNinchishoNichijoSeikatsuJiritsudoCode().setDisabled(true);
        kihonDiv.getKihonChosaPanel().getTxtShogaiNichijoSeikatsuJiritsudoCode().setDisabled(true);
        kihonDiv.getBtnReturn().setDisabled(false);
        setDataSourcre1(申請書管理番号, chosaKekkaInfoGaikyoList);
        setDataSourcre2(serviceJokyos);
        setChosaTokkiImageShokai(serviceJokyos);
    }

    private void setChosaTokkiImageShokai(List<TokiJikouBusiness> serviceJokyos) {
        List<RString> 認定調査特記事項番号List = set認定調査特記事項番号List();
        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        if (serviceJokyos != null && !serviceJokyos.isEmpty()) {
            ArrayList<NinteichosahyoTokkijiko> 認定調査特記事項情報List = manager.get調査特記事項(
                    serviceJokyos.get(0).get申請書管理番号(), serviceJokyos.get(0).get認定調査依頼履歴番号(), 認定調査特記事項番号List);
            if (認定調査特記事項情報List != null && !認定調査特記事項情報List.isEmpty()) {
                kihonDiv.getKihonChosaPanel().getBtnChosaTokkiImageShokai().setDisplayNone(false);
                ArrayList<RString> 特記事項番号List = new ArrayList<>();
                for (NinteichosahyoTokkijiko 特記事項情報 : 認定調査特記事項情報List) {
                    特記事項番号List.add(特記事項情報.get認定調査特記事項番号());
                }
                kihonDiv.setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(特記事項番号List));
            }
        }
    }

    private List<RString> set認定調査特記事項番号List() {
        List<RString> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List.add(new RString("T001"));
        認定調査特記事項番号List.add(new RString("T002"));
        認定調査特記事項番号List.add(new RString("T003"));
        認定調査特記事項番号List.add(new RString("T004"));
        認定調査特記事項番号List.add(new RString("T005"));
        認定調査特記事項番号List.add(new RString("T006"));
        認定調査特記事項番号List.add(new RString("T007"));
        認定調査特記事項番号List.add(new RString("T008"));
        return 認定調査特記事項番号List;
    }

    /**
     * 利用施設一覧を取得します。
     */
    private void setDataSourcre1(RString 申請書管理番号, List<ChosaKekkaInfoKihonBusiness> chosaKekkaInfoKihonList) {
        List<ChosaKekkaInfoKihonBusiness> chosaKekkaInfoKihonListCopy = new ArrayList<>(chosaKekkaInfoKihonList);
        chosaKekkaInfoKihonList = get認定調査結果基本(chosaKekkaInfoKihonListCopy);
        if (chosaKekkaInfoKihonList != null && !chosaKekkaInfoKihonList.isEmpty()) {
//            if (chosaKekkaInfoKihon.get認定調査実施年月日() != null) {
//                kihonDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(chosaKekkaInfoKihon.get認定調査実施年月日().toString()));
//            }
//            if (TokkijikoTextImageKubun.テキスト.getコード().equals(chosaKekkaInfoKihon.get概況調査テキストイメージ区分())) {
//                kihonDiv.getJisshiBashoMeishoPanel().setDisplayNone(true);
//                kihonDiv.getTxtChosaJisshiBashoMeisho().setValue(chosaKekkaInfoKihon.get認定調査実施場所名称());
//            } else {
//                kihonDiv.getTxtChosaJisshiBashoMeisho().setDisplayNone(true);
//                ImageManager imageManager = InstanceProvider.create(ImageManager.class);
//                Image イメージ情報 = imageManager.getイメージ情報(new ShinseishoKanriNo(申請書管理番号));
//                setImage認定調査実施場所(イメージ情報);
//            }
            kihonDiv.getKihonChosaPanel().getTxtNinchishoNichijoSeikatsuJiritsudoCode().setValue(NinchishoNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoKihonList.get(0).get認定調査_認知症高齢者の日常生活自立度コード().toString())).get名称());
            kihonDiv.getKihonChosaPanel().getTxtShogaiNichijoSeikatsuJiritsudoCode().setValue(ShogaiNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoKihonList.get(0).get認定調査_障害高齢者の日常生活自立度コード().toString())).get名称());
        }
    }

    private List<ChosaKekkaInfoKihonBusiness> get認定調査結果基本(List<ChosaKekkaInfoKihonBusiness> 認定調査結果基本List) {
        RString 概況調査テキストイメージ区分 = RString.EMPTY;
        int テキストイメージ区分レコードカウント = 0;
        for (ChosaKekkaInfoKihonBusiness 認定調査結果基本Entity : 認定調査結果基本List) {
            if (RString.isNullOrEmpty(概況調査テキストイメージ区分)) {
                概況調査テキストイメージ区分 = 認定調査結果基本Entity.get概況調査テキストイメージ区分();
                テキストイメージ区分レコードカウント++;
            }
            if (!概況調査テキストイメージ区分.equals(認定調査結果基本Entity.get概況調査テキストイメージ区分())) {
                テキストイメージ区分レコードカウント++;
                break;
            }
        }
        if (テキストイメージ区分レコードカウント > 1) {
            List<ChosaKekkaInfoKihonBusiness> 認定調査結果基本ListCopy = new ArrayList<>(認定調査結果基本List);
            認定調査結果基本List = remove認定調査結果基本一覧(認定調査結果基本ListCopy);
        }
        return 認定調査結果基本List;
    }

    private List<ChosaKekkaInfoKihonBusiness> remove認定調査結果基本一覧(List<ChosaKekkaInfoKihonBusiness> 認定調査結果基本List) {
        List<ChosaKekkaInfoKihonBusiness> イメージのみ認定調査結果基本List = new ArrayList<>();
        for (ChosaKekkaInfoKihonBusiness 認定調査結果基本Entity : 認定調査結果基本List) {
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(認定調査結果基本Entity.get概況調査テキストイメージ区分())) {
                イメージのみ認定調査結果基本List.add(認定調査結果基本Entity);
            }
        }
        return イメージのみ認定調査結果基本List;
    }

    private void setImage認定調査実施場所(Image image) {
        RString 実施場所ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_認定調査実施場所);
        kihonDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setSrc(実施場所ImagePath);
    }

    private RString 共有ファイルを引き出す(Image イメージ情報, RString ファイル名) {
        RString imagePath = RString.EMPTY;
        if (イメージ情報 != null) {
            imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), ファイル名);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        RString FileaPath = SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath)).toRString();
        return getImageSrc(Path.combinePath(FileaPath, sharedFileName));
    }

    private RString getImageSrc(RString path) {
        return Path.combinePath(new RString(File.separator + "db"), new RString("dbe"), path.substring(path.indexOf("image")));
    }

    /**
     * 概況調査_サービス状況を取得します。
     */
    private List<dgKihonChosa_Row> setDataSourcre2(List<TokiJikouBusiness> serviceJokyos) {
        List<dgKihonChosa_Row> grdSinsaSeiList = new ArrayList<>();
        for (TokiJikouBusiness chosaItem : serviceJokyos) {
            dgKihonChosa_Row dgJigyoshaItiran = new dgKihonChosa_Row();
            ArrayList<RString> 認定調査特記事項番号List = new ArrayList<>();
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get名称());
                dgJigyoshaItiran.setKaitou(get回答(chosaItem, NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo()));
                認定調査特記事項番号List.add(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get名称());
                dgJigyoshaItiran.setKaitou(get回答(chosaItem, NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo()));
                認定調査特記事項番号List.add(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get名称());
                dgJigyoshaItiran.setKaitou(get回答(chosaItem, NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo()));
                認定調査特記事項番号List.add(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get名称());
                dgJigyoshaItiran.setKaitou(get回答(chosaItem, NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo()));
                認定調査特記事項番号List.add(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                for (NinteichosaKomokuMapping09B value : NinteichosaKomokuMapping09B.values()) {
                    if (new RString(chosaItem.get連番()).equals(value.getコード())) {
                        dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get表示番号());
                        dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get名称());
                        dgJigyoshaItiran.setKaitou(get回答(chosaItem, NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo()));
                        認定調査特記事項番号List.add(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                    }
                }
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
            ArrayList<NinteichosahyoTokkijiko> list = manager.get調査特記事項(chosaItem.get申請書管理番号(), chosaItem.get認定調査依頼履歴番号(), 認定調査特記事項番号List);
            if (list.isEmpty()) {
                dgJigyoshaItiran.getBtnTokkiJiko().setDisplayNone(true);
            } else {
                dgJigyoshaItiran.getBtnTokkiJiko().setDisabled(false);
            }
            grdSinsaSeiList.add(dgJigyoshaItiran);
        }
        kihonDiv.getKihonChosaPanel().getDgKihonChosa().setDataSource(grdSinsaSeiList);
        return grdSinsaSeiList;
    }

    private RString get回答(TokiJikouBusiness chosaItem, RString 回答パターン) {
        if (AnswerPattern.回答パターン1.getコード().equals(回答パターン)) {
            return ChosaAnser01.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン2.getコード().equals(回答パターン)) {
            return ChosaAnser02.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン3.getコード().equals(回答パターン)) {
            return ChosaAnser03.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン4.getコード().equals(回答パターン)) {
            return ChosaAnser04.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン5.getコード().equals(回答パターン)) {
            return ChosaAnser05.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン6.getコード().equals(回答パターン)) {
            return ChosaAnser06.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン7.getコード().equals(回答パターン)) {
            return ChosaAnser07.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン8.getコード().equals(回答パターン)) {
            return ChosaAnser08.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン9.getコード().equals(回答パターン)) {
            return ChosaAnser09.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン10.getコード().equals(回答パターン)) {
            return ChosaAnser10.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン11.getコード().equals(回答パターン)) {
            return ChosaAnser11.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン12.getコード().equals(回答パターン)) {
            return ChosaAnser12.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン13.getコード().equals(回答パターン)) {
            return ChosaAnser13.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン14.getコード().equals(回答パターン)) {
            return ChosaAnser14.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン15.getコード().equals(回答パターン)) {
            return ChosaAnser15.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン16.getコード().equals(回答パターン)) {
            return ChosaAnser16.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン17.getコード().equals(回答パターン)) {
            return ChosaAnser17.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン20.getコード().equals(回答パターン)) {
            return ChosaAnser20.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン21.getコード().equals(回答パターン)) {
            return ChosaAnser21.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン22.getコード().equals(回答パターン)) {
            return ChosaAnser22.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン23.getコード().equals(回答パターン)) {
            return ChosaAnser23.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン24.getコード().equals(回答パターン)) {
            return ChosaAnser24.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン30.getコード().equals(回答パターン)) {
            return ChosaAnser30.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン31.getコード().equals(回答パターン)) {
            return ChosaAnser31.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン32.getコード().equals(回答パターン)) {
            return ChosaAnser32.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン33.getコード().equals(回答パターン)) {
            return ChosaAnser33.toValue(chosaItem.get調査項目()).get名称();
        }
        if (AnswerPattern.回答パターン34.getコード().equals(回答パターン)) {
            return ChosaAnser34.toValue(chosaItem.get調査項目()).get名称();
        }
        return RString.EMPTY;
    }
}

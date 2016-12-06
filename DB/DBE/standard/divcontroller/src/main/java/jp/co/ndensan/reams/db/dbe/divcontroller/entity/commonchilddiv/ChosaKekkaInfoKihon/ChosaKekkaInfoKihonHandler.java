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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser23;
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
        kihonDiv.getTxtNinteichosaJisshiYMD().setDisabled(true);
        kihonDiv.getTxtChosaJisshiBashoMeisho().setDisabled(true);
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
        ChosaKekkaInfoKihonBusiness chosaKekkaInfoKihon = get認定調査結果基本(chosaKekkaInfoKihonList);
        if (chosaKekkaInfoKihon != null) {
            if (chosaKekkaInfoKihon.get認定調査実施年月日() != null) {
                kihonDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(chosaKekkaInfoKihon.get認定調査実施年月日().toString()));
            }
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(chosaKekkaInfoKihon.get概況調査テキストイメージ区分())) {
                kihonDiv.getJisshiBashoMeishoPanel().setDisplayNone(true);
                kihonDiv.getTxtChosaJisshiBashoMeisho().setValue(chosaKekkaInfoKihon.get認定調査実施場所名称());
            } else {
                kihonDiv.getTxtChosaJisshiBashoMeisho().setDisplayNone(true);
                ImageManager imageManager = InstanceProvider.create(ImageManager.class);
                Image イメージ情報 = imageManager.getイメージ情報(new ShinseishoKanriNo(申請書管理番号));
                setImage認定調査実施場所(イメージ情報);
            }
            kihonDiv.getKihonChosaPanel().getTxtNinchishoNichijoSeikatsuJiritsudoCode().setValue(NinchishoNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoKihon.get認定調査_認知症高齢者の日常生活自立度コード().toString())).get名称());
            kihonDiv.getKihonChosaPanel().getTxtShogaiNichijoSeikatsuJiritsudoCode().setValue(ShogaiNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoKihon.get認定調査_障害高齢者の日常生活自立度コード().toString())).get名称());
        }
    }
    
    private ChosaKekkaInfoKihonBusiness get認定調査結果基本(List<ChosaKekkaInfoKihonBusiness> 認定調査結果基本List) {
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
        return 認定調査結果基本List.get(0);
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
                setパターン1(dgJigyoshaItiran, chosaItem);
                認定調査特記事項番号List.add(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン2(dgJigyoshaItiran, chosaItem);
                認定調査特記事項番号List.add(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン3(dgJigyoshaItiran, chosaItem);
                認定調査特記事項番号List.add(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン4(dgJigyoshaItiran, chosaItem);
                認定調査特記事項番号List.add(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get特記事項番号());
                dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(chosaItem.get厚労省IF識別コード().value())) {
                for (NinteichosaKomokuMapping09B value : NinteichosaKomokuMapping09B.values()) {
                    if (new RString(chosaItem.get連番()).equals(value.getコード())) {
                        dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get表示番号());
                        dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get名称());
                        setパターン5(dgJigyoshaItiran, chosaItem);
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

    private void setパターン1(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン2(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン3(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン4(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン5(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }
}

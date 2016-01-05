/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist;

import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 異動チェックリスト帳票データ作成のプロセスクラス
 */
public class ReportParamProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private List<IdoInfoEntity> list;
//    private IIdoCheckListMapper mapper;
//    private IdoCheckListInfo idoCheckListInfo;
//    private IdoCheckListGetDataProcessParameter param;
//
//    protected void initialize() {
//        list = new ArrayList<>();
//        mapper = getMapper(IIdoCheckListMapper.class);
//        idoCheckListInfo = new IdoCheckListInfo();
//    }
//
//    @Override
//    protected void beforeExecute() {
//
//    }
//
//    @Override
//    protected void afterExecute() {
//    }
//
//    @Override
//    protected void process() {
//        IAssociationFinder finder = AssociationFinderFactory.createInstance();
//
//        Association association = finder.getAssociation();
//        idoCheckListInfo.set市町村コード(association.get地方公共団体コード());
//        idoCheckListInfo.set市町村名(association.get市町村名());
//        // TODO 並び順と改頁を作成する
//
//        if (param.isHihokenshaDaichouFlag()) {
//            List<IdoInfoEntity> hihokenshaDaichouList = mapper.getHihokenshaDaichouList(
//                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
//                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), RString.EMPTY));
//            if (hihokenshaDaichouList.isEmpty()) {
//                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
//                idoInfoEntity.set対象情報(1);
//                idoInfoEntity.set対象情報タイトル(new RString("データ種別：被保険者台帳"));
//                idoInfoEntity.set開始タイトル(new RString("取得情報"));
//                idoInfoEntity.set終了タイトル(new RString("喪失情報"));
//                idoInfoEntity.set区分タイトル(new RString("資格"));
//                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
//                list.add(idoInfoEntity);
//            }
//            list.addAll(hihokenshaDaichouList);
//        }
//        if (param.isJushochiTokureiKanriFlag()) {
//            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode08List = mapper.getJushochiTokureiListByCode08(
//                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
//                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), RString.EMPTY));
//            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoCode11List = mapper.getJushochiTokureiListByCode11(
//                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
//                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), RString.EMPTY));
//            List<ShisetsuNyutaishoEntity> shisetsuNyutaishoList = mapper.getShisetsuNyutaishoList(
//                    IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
//                            param.getKonkaiKaishi(), param.getKonkaiShuryo(), DaichoType.他市町村住所地特例者.getコード()));
//            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode08List);
//            shisetsuNyutaishoList.addAll(shisetsuNyutaishoCode11List);
//            Collections.sort(shisetsuNyutaishoList, new DateComparator());
//
//            for (ShisetsuNyutaishoEntity entity : shisetsuNyutaishoList) {
//                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
//                idoInfoEntity.set世帯コード(null);
//                idoInfoEntity.set被保険者カナ氏名(null);
//                idoInfoEntity.set被保険者氏名(null);
//                idoInfoEntity.set対象情報(2);
//                idoInfoEntity.set改頁１(null);
//                idoInfoEntity.set改頁２(null);
//                idoInfoEntity.set改頁３(null);
//                idoInfoEntity.set改頁４(null);
//                idoInfoEntity.set改頁５(null);
//                idoInfoEntity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
//                idoInfoEntity.set開始タイトル(new RString("適用情報"));
//                idoInfoEntity.set終了タイトル(new RString("解除情報"));
//                idoInfoEntity.set区分タイトル(null);
//                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
//                idoInfoEntity.set異動情報タイトル2(null);
//                idoInfoEntity.set異動情報タイトル3(null);
//                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
//                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
//                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
//                idoInfoEntity.set異動情報タイトル5(null);
//                idoInfoEntity.set異動情報タイトル6(null);
//                idoInfoEntity.set異動情報データ1(entity.get入所施設コード().value());
//                idoInfoEntity.set被保険者番号(null);
//                idoInfoEntity.set識別コード(entity.get識別コード());
//                idoInfoEntity.set区分_前_資格(null);
//                idoInfoEntity.set区分_後_資格(null);
//                idoInfoEntity.set異動情報データ2(null);
//                idoInfoEntity.set異動情報データ3(null);
//                idoInfoEntity.set異動情報データ5(null);
//                idoInfoEntity.set異動情報データ6(null);
//                if (!entity.is論理削除フラグ()) {
//                    idoInfoEntity.set取得情報_前_事由(null);
//                    idoInfoEntity.set取得情報_前_異動年月日(null);
//                    idoInfoEntity.set取得情報_前_届出年月日(null);
//                    idoInfoEntity.set開始年月日データ_前(null);
//                    idoInfoEntity.set喪失情報_前_事由(null);
//                    idoInfoEntity.set喪失情報_前_異動年月日(null);
//                    idoInfoEntity.set喪失情報_前_届出年月日(null);
//                    idoInfoEntity.set終了年月日データ_前(null);
//                    List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(new RString("0008")));
//                    boolean flag = false;
//                    for (UzT0007CodeEntity codeEntity : codeList) {
//                        if (entity.get異動事由コード().equals(codeEntity.getコード().value())) {
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        idoInfoEntity.set取得情報_後_事由(entity.get異動事由コード());
//                        idoInfoEntity.set取得情報_後_異動年月日(entity.get適用年月日());
//                        idoInfoEntity.set取得情報_後_届出年月日(entity.get適用届出年月日());
//                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_後(null);
//                        idoInfoEntity.set異動情報データ4(new RString("適用異動"));
//                    }
//
//                    if (entity.get異動事由コード() == null
//                            && entity.get入所年月日() != null
//                            && entity.get退所年月日() == null) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_後(null);
//                        idoInfoEntity.set異動情報データ4(new RString("入所異動"));
//                    }
//
//                    if (entity.get異動事由コード() == null
//                            && entity.get入所年月日() != null
//                            && entity.get退所年月日() != null) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_後(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_後_事由(null);
//                        idoInfoEntity.set喪失情報_後_異動年月日(null);
//                        idoInfoEntity.set喪失情報_後_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
//                        idoInfoEntity.set異動情報データ4(new RString("退所異動"));
//                    }
//
//                    codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(new RString("0011")));
//                    flag = false;
//                    for (UzT0007CodeEntity codeEntity : codeList) {
//                        if (entity.get異動事由コード().equals(codeEntity.getコード().value())) {
//                            flag = true;
//                            break;
//                        }
//                    }
//
//                    if (flag) {
//                        idoInfoEntity.set取得情報_後_事由(null);
//                        idoInfoEntity.set取得情報_後_異動年月日(null);
//                        idoInfoEntity.set取得情報_後_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_後(null);
//                        idoInfoEntity.set喪失情報_後_事由(entity.get異動事由コード());
//                        idoInfoEntity.set喪失情報_後_異動年月日(entity.get解除年月日());
//                        idoInfoEntity.set喪失情報_後_届出年月日(entity.get解除届出年月日());
//                        idoInfoEntity.set終了年月日データ_後(entity.get退所年月日());
//                        idoInfoEntity.set異動情報データ4(new RString("解除異動"));
//                    }
//                } else {
//                    idoInfoEntity.set取得情報_後_事由(null);
//                    idoInfoEntity.set取得情報_後_異動年月日(null);
//                    idoInfoEntity.set取得情報_後_届出年月日(null);
//                    idoInfoEntity.set開始年月日データ_後(null);
//                    idoInfoEntity.set喪失情報_後_事由(null);
//                    idoInfoEntity.set喪失情報_後_異動年月日(null);
//                    idoInfoEntity.set喪失情報_後_届出年月日(null);
//                    idoInfoEntity.set終了年月日データ_後(null);
//                    List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(new RString("0008")));
//                    boolean flag = false;
//                    for (UzT0007CodeEntity codeEntity : codeList) {
//                        if (entity.get異動事由コード().equals(codeEntity.getコード().value())) {
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        idoInfoEntity.set取得情報_前_事由(entity.get異動事由コード());
//                        idoInfoEntity.set取得情報_前_異動年月日(entity.get適用年月日());
//                        idoInfoEntity.set取得情報_前_届出年月日(entity.get適用届出年月日());
//                        idoInfoEntity.set開始年月日データ_前(entity.get入所年月日());
//                        idoInfoEntity.set喪失情報_前_事由(null);
//                        idoInfoEntity.set喪失情報_前_異動年月日(null);
//                        idoInfoEntity.set喪失情報_前_届出年月日(null);
//                        idoInfoEntity.set終了年月日データ_前(null);
//                        idoInfoEntity.set異動情報データ4(new RString("適用削除"));
//                    }
//
//                    codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu(new RString("0011")));
//                    flag = false;
//                    for (UzT0007CodeEntity codeEntity : codeList) {
//                        if (entity.get異動事由コード().equals(codeEntity.getコード().value())) {
//                            flag = true;
//                            break;
//                        }
//                    }
//
//                    if (flag) {
//                        idoInfoEntity.set取得情報_前_事由(null);
//                        idoInfoEntity.set取得情報_前_異動年月日(null);
//                        idoInfoEntity.set取得情報_前_届出年月日(null);
//                        idoInfoEntity.set開始年月日データ_前(null);
//                        idoInfoEntity.set喪失情報_前_事由(entity.get異動事由コード());
//                        idoInfoEntity.set喪失情報_前_異動年月日(entity.get解除年月日());
//                        idoInfoEntity.set喪失情報_前_届出年月日(entity.get解除届出年月日());
//                        idoInfoEntity.set終了年月日データ_前(entity.get退所年月日());
//                        idoInfoEntity.set異動情報データ4(new RString("解除解除"));
//                    }
//
//                }
//                list.add(idoInfoEntity);
//            }
//
//            if (shisetsuNyutaishoList.isEmpty()) {
//                IdoInfoEntity idoInfoEntity = new IdoInfoEntity();
//                idoInfoEntity.set世帯コード(null);
//                idoInfoEntity.set被保険者カナ氏名(null);
//                idoInfoEntity.set被保険者氏名(null);
//                idoInfoEntity.set対象情報(2);
//                idoInfoEntity.set改頁１(null);
//                idoInfoEntity.set改頁２(null);
//                idoInfoEntity.set改頁３(null);
//                idoInfoEntity.set改頁４(null);
//                idoInfoEntity.set改頁５(null);
//                idoInfoEntity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
//                idoInfoEntity.set開始タイトル(new RString("適用情報"));
//                idoInfoEntity.set終了タイトル(new RString("解除情報"));
//                idoInfoEntity.set区分タイトル(null);
//                idoInfoEntity.set異動情報タイトル1(new RString("施設コード"));
//                idoInfoEntity.set異動情報タイトル2(null);
//                idoInfoEntity.set異動情報タイトル3(null);
//                idoInfoEntity.set開始年月日タイトル(new RString("入所年月日"));
//                idoInfoEntity.set終了年月日タイトル(new RString("退所年月日"));
//                idoInfoEntity.set異動情報タイトル4(new RString("異動情報"));
//                idoInfoEntity.set異動情報タイトル5(null);
//                idoInfoEntity.set異動情報タイトル6(null);
//                idoInfoEntity.set開始年月日データ_前(null);
//                idoInfoEntity.set終了年月日データ_前(null);
//                idoInfoEntity.set開始年月日データ_後(null);
//                idoInfoEntity.set終了年月日データ_後(null);
//                idoInfoEntity.set異動情報データ1(null);
//                idoInfoEntity.set異動情報データ2(null);
//                idoInfoEntity.set異動情報データ3(null);
//                idoInfoEntity.set異動情報データ4(null);
//                idoInfoEntity.set異動情報データ5(null);
//                idoInfoEntity.set異動情報データ6(null);
//                idoInfoEntity.set被保険者番号(null);
//                idoInfoEntity.set識別コード(null);
//                idoInfoEntity.set取得情報_前_事由(null);
//                idoInfoEntity.set取得情報_前_異動年月日(null);
//                idoInfoEntity.set取得情報_前_届出年月日(null);
//                idoInfoEntity.set喪失情報_前_事由(null);
//                idoInfoEntity.set喪失情報_前_異動年月日(null);
//                idoInfoEntity.set喪失情報_前_届出年月日(null);
//                idoInfoEntity.set取得情報_後_事由(null);
//                idoInfoEntity.set取得情報_後_異動年月日(null);
//                idoInfoEntity.set取得情報_後_届出年月日(null);
//                idoInfoEntity.set喪失情報_後_事由(null);
//                idoInfoEntity.set喪失情報_後_異動年月日(null);
//                idoInfoEntity.set喪失情報_後_届出年月日(null);
//                idoInfoEntity.set区分_前_資格(null);
//                idoInfoEntity.set区分_後_資格(null);
//
//                list.add(idoInfoEntity);
//            }
//        }
//
//        // TODO 適用除外者台帳リスト取得
//    }
//
//    private class DateComparator implements Comparator<ShisetsuNyutaishoEntity> {
//
//        @Override
//        public int compare(ShisetsuNyutaishoEntity o1, ShisetsuNyutaishoEntity o2) {
//            return o1.get更新日時().compareTo(o2.get更新日時());
//        }
//    }
}
